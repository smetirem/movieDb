/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kyriakos-work-laptop
 * Created: Feb 21, 2019
 */

DELETE FROM Favorite_list WHERE Id IS NOT NULL;
DELETE FROM Movie WHERE Id IS NOT NULL;
DELETE FROM Genre WHERE Id IS NOT NULL;


create table Genre (
id int not null,
name varchar(20),
primary key(id)
);


create table Movie (
id int not null,
title varchar (100),
genre_id int,
release_date date,
vote_average float(10),
overview varchar (500),
favorite_list_id int,
primary key (id)
);


create table Favorite_list(
id int not null,
name varchar (50),
primary key (id)
);


ALTER TABLE movie ADD FOREIGN KEY(genre_id) REFERENCES GENRE(ID);
ALTER TABLE movie ADD FOREIGN KEY(favorite_list_id) REFERENCES FAVORITE_LIST(ID);