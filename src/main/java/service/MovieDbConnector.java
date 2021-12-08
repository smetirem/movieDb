
    package service;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;
    import com.google.gson.JsonObject;
    import com.google.gson.JsonParser;
    import java.io.IOException;
    import java.net.URI;
    import java.net.URISyntaxException;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.stream.Collectors;
    import java.util.stream.IntStream;
    import javax.persistence.EntityManager;
    import models.Genre;
    import models.jsonResponse.*;
    import models.Movie;
    import org.apache.commons.io.IOUtils;
    import org.apache.http.HttpResponse;
    import org.apache.http.NameValuePair;
    import org.apache.http.client.HttpClient;
    import org.apache.http.client.methods.HttpGet;
    import org.apache.http.client.utils.URIBuilder;
    import org.apache.http.impl.client.HttpClientBuilder;
    import org.apache.http.message.BasicNameValuePair;


    public class MovieDbConnector {

        public MovieDbConnector() {
        }

        private final HttpClient httpClient = HttpClientBuilder.create().build();
        private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        private static final String APIKEY = "fee4a46613c53070917f4ca39df8e0c2";
        private final String apiURL = "api.themoviedb.org/3/";
        private final String genrePath = "genre/movie/list";
        private final String moviesPath = "discover/movie";

        private static final List<NameValuePair> genreParameters = new ArrayList<NameValuePair>(1);

        static {
            genreParameters.add(new BasicNameValuePair("api_key", APIKEY));
            genreParameters.add(new BasicNameValuePair("language", "en-US"));
        }

        private URI buildURL(String apiURL, String path, java.util.List<NameValuePair> nvps, int counter) throws URISyntaxException {
            String page = Integer.toString(counter);
            if (counter == 0) {
                return new URIBuilder()
                        .setParameters(nvps)
                        .setScheme("https")
                        .setHost(apiURL)
                        .setPath(path)
                        .build();
            } else {
                nvps.add(nvps.size(), new BasicNameValuePair("page", page));
                URI URI = new URIBuilder()
                        .setParameters(nvps)
                        .setScheme("https")
                        .setHost(apiURL)
                        .setPath(path)
                        .build();
                nvps.remove(nvps.size() - 1);
                return URI;
            }

        }

        /**
         *
         * @param con
         * @return
         * @throws Exception
         */
        public GenresList getAvailableGenres(EntityManager con) throws Exception {
            HttpGet get = new HttpGet(buildURL(this.apiURL, this.genrePath, genreParameters, 0));
            HttpResponse response = httpClient.execute(get);
            int responseCode = response.getStatusLine().getStatusCode();
            GenresList listGenreResponse = null;

            if (responseCode == 200) {

                listGenreResponse = gson.fromJson(parseResponse(response), GenresList.class);
                get.releaseConnection();
                if(listGenreResponse != null){
                    saveGenresToDerbyDb(listGenreResponse, con);
                }
            } else {

                String errMessage = gson.toJson(parseResponse(response));
                System.out.println(errMessage);

                get.releaseConnection();

            }

            return listGenreResponse;
        }

        private JsonObject parseResponse(HttpResponse response) throws IOException {
            JsonParser parser = new JsonParser();
            JsonObject test = parser.parse(IOUtils.toString(response.getEntity().getContent(), "UTF-8")).getAsJsonObject();
            return test;

        }

        private void saveGenresToDerbyDb(GenresList genrelist, EntityManager con) {
            genrelist.getGenres().stream().filter((Genre genre) -> {
                return ("Romance".equals(genre.getName()) || "Science Fiction".equals(genre.getName()) || "Action".equals(genre.getName()));
            }).forEach((genre) -> {
                con.getTransaction().begin();
                con.persist(genre);
                con.getTransaction().commit();
            });

        }

        /**
         *
         * @param page
         * @param genreList
         * @param con
         * @throws Exception
         */
        public String getAvailableMoviesPerPage(int page, GenresList genreList, EntityManager con) throws Exception {

            Map<Integer, Movie> moviesHashed = new HashMap();
            ArrayList<DiscoverResponse> movieResponses
                    = IntStream.rangeClosed(1, page).parallel().mapToObj(p -> {
                        DiscoverResponse resp = null;

                        try {

                            List<NameValuePair> moviesParameters = new ArrayList<NameValuePair>();

                            moviesParameters.add(new BasicNameValuePair("with_genres", "10749|878|28"));
                            moviesParameters.add(new BasicNameValuePair("language", "en-US"));
                            moviesParameters.add(new BasicNameValuePair("release_date.gte", "2000"));
                            moviesParameters.add(new BasicNameValuePair("api_key", APIKEY));
                            moviesParameters.add(new BasicNameValuePair("sort_by", "original_title_asc"));

                            HttpGet get = new HttpGet(buildURL(this.apiURL, this.moviesPath, moviesParameters, p));
                            HttpResponse response = httpClient.execute(get);
                            int responseCode = response.getStatusLine().getStatusCode();
                            if (responseCode == 200) {
                                resp = gson.fromJson(parseResponse(response), DiscoverResponse.class);
                                get.releaseConnection();

                            } else {

                                String errMessage = gson.toJson(parseResponse(response));
                                System.out.println(errMessage);

                                get.releaseConnection();
                            }

                        } catch (Exception exception) {
                            System.err.print(exception.getCause());
                        }

                        return resp;
                    }).collect(Collectors.toCollection(ArrayList::new));

            movieResponses.forEach(resp -> System.out.println(resp));

            /*
            while (page > 0) {
                HttpGet get = new HttpGet(buildURL(this.apiURL, this.moviesPath, MovieDbConnector.moviesParameters, page));
                HttpResponse response = httpClient.execute(get);
                int responseCode = response.getStatusLine().getStatusCode();

                if (responseCode == 200) {
                    DiscoverResponse resp = gson.fromJson(parseResponse(response), DiscoverResponse.class);

                    movieResponses.add(resp);

    //                listMovieResponse.stream().filter(movie -> resp.getResults().contains(movie)).forEach(movie -> System.out.println(movie.getTitle()));
                    page--;
                    get.releaseConnection();

                } else {

                    String errMessage = gson.toJson(parseResponse(response));

                    get.releaseConnection();

                    throw new Exception(String.format("Could not list the movies:\n %s",
                            errMessage));
                }


            }
             */

            String ResponseMessage = "";

            movieResponses.forEach((response) -> {
                if(response != null){
                    moviesHashed.putAll(response.getMapped());
                }
            });

            if (!moviesHashed.isEmpty()){
                saveMoviesToDerbyDb(genreList, moviesHashed, con);
            } else {
                ResponseMessage.concat("There was a problem with connecting to MovieDb");
            }

            return ResponseMessage;

        }

        private void saveMoviesToDerbyDb(GenresList genereList, Map<Integer, Movie> movielist, EntityManager con) throws InterruptedException {

            movielist.entrySet().stream().forEach((response) -> {
                Movie movie = response.getValue();

                con.getTransaction().begin();

                String overview = movie.getOverview().substring(0, Math.min(254, movie.getOverview().length()));
                movie.setOverview(overview);

                int genreId = movie.getGenreIds().stream().filter((i) -> {
                    return i == 10749 || i == 878 || i == 28;
                }).findFirst().orElse(null);
                movie.setGenreId(genereList.getGenres()
                        .stream()
                        .filter(i -> i.getId() == genreId)
                        .findFirst().orElse(null));
                con.persist(movie);
    //            System.out.println(movielist.get(x).getTitle() + "\n");
                con.getTransaction().commit();
            });
        }


    }
