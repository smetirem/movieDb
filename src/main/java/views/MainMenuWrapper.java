package views;


import controllers.DerbyDBConnector;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.jsonResponse.GenresList;
import mymovies.MyMovies;
import service.MovieDbConnector;


public class MainMenuWrapper extends javax.swing.JFrame {

//Δημιουργία και δήλωση των δευτερευόντων παραθύρων 
EditListsWrapper editLists = new EditListsWrapper();
SearchWrapper search = new SearchWrapper();
StatisticsWrapper statistics = new StatisticsWrapper();
    
    
private static final int MAX_NUMBER_OF_CALLS = 39;
private DerbyDBConnector db = new DerbyDBConnector();
public static final EntityManager con = DerbyDBConnector.createEntityManager();


    public MainMenuWrapper() {
        initComponents();
        //Τοποθέτηση Internal Frames στο κετρικό DesktopPane
        jDesktopPaneMain.add(editLists);
        jDesktopPaneMain.add(search);
        jDesktopPaneMain.add(statistics); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpMenu = new javax.swing.JPopupMenu();
        getMoviesItem = new javax.swing.JMenuItem();
        searchItem = new javax.swing.JMenuItem();
        editItem = new javax.swing.JMenuItem();
        statisticsItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();
        jDesktopPaneMain = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        aboutLabel1 = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();

        getMoviesItem.setText("Ανάκτηση και Αποθήκευση Ταινιών");
        getMoviesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMoviesItemActionPerformed(evt);
            }
        });
        popUpMenu.add(getMoviesItem);

        searchItem.setText("Αναζήτηση");
        searchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemActionPerformed(evt);
            }
        });
        popUpMenu.add(searchItem);

        editItem.setText("Επεξεργασία Λιστών");
        editItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemActionPerformed(evt);
            }
        });
        popUpMenu.add(editItem);

        statisticsItem.setText("Στατιστικά");
        statisticsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsItemActionPerformed(evt);
            }
        });
        popUpMenu.add(statisticsItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyMovies");
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(104, 115, 145));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jLabel1.setFont(new java.awt.Font("Tiger Expert", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("My Movies");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIconTextGap(0);
        jLabel1.setMaximumSize(new java.awt.Dimension(882, 100));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        MenuButton.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(51, 51, 51));
        MenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectIcons/menuicon.png"))); // NOI18N
        MenuButton.setBorder(null);
        MenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(MenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jDesktopPaneMain.setBackground(new java.awt.Color(255, 255, 204));
        jDesktopPaneMain.setPreferredSize(new java.awt.Dimension(724, 511));
        jDesktopPaneMain.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jDesktopPaneMainLayout = new javax.swing.GroupLayout(jDesktopPaneMain);
        jDesktopPaneMain.setLayout(jDesktopPaneMainLayout);
        jDesktopPaneMainLayout.setHorizontalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPaneMainLayout.setVerticalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        aboutLabel1.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        aboutLabel1.setText("About");
        aboutLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutLabel1MouseClicked(evt);
            }
        });

        exitLabel.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        exitLabel.setText("Exit");
        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aboutLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aboutLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDesktopPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        popUpMenu.show((Component)evt.getSource(), 0, 55); 
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    try {
    setIconImage(ImageIO.read(new File("src/main/resources/ProjectIcons/frameicon.png")));
    }
    catch (IOException exc) {
    exc.printStackTrace();
    }
    }//GEN-LAST:event_formWindowOpened

    private void getMoviesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getMoviesItemActionPerformed
          try {
            MovieDbConnector con1 = new MovieDbConnector();
            DerbyDBConnector.clearTable();
            String messageMovies = "";
            GenresList genreList = con1.getAvailableGenres(con);
            if (genreList == null) {
                messageMovies.concat("Could not get the genres");
            } else {
                messageMovies = con1.getAvailableMoviesPerPage(MAX_NUMBER_OF_CALLS, genreList, con);
                // editLists.clearJlistComponent();
                JOptionPane.showMessageDialog( null,"Επιτυχής ανάκτηση και αποθήκευση ταινιών","Ολοκληρώθηκε", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println(messageMovies);
        } catch (Exception ex) {
            Logger.getLogger(MyMovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_getMoviesItemActionPerformed

    private void searchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemActionPerformed
        search.refreshComboBox();
        //Αν το παράθυρο είναι απενεργοποιημένο να ανοίξει και αν οχι να έρθει μπροστά.
        if (!search.isVisible())  
        search.setVisible(true);
        else        
        search.toFront();
    }//GEN-LAST:event_searchItemActionPerformed

    private void editItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemActionPerformed
        //      Αν το παράθυρο είναι απενεργοποιημένο να ανοίξει και αν οχι να έρθει μπροστά.
        if (!editLists.isVisible())  
        editLists.setVisible(true);
        else        
        editLists.toFront();
    }//GEN-LAST:event_editItemActionPerformed

    private void statisticsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsItemActionPerformed
        //Αν το παράθυρο είναι απενεργοποιημένο να ανοίξει και αν οχι να έρθει μπροστά.
        if (!statistics.isVisible())  
        statistics.setVisible(true);
        else
        statistics.toFront();  
    }//GEN-LAST:event_statisticsItemActionPerformed

    private void aboutLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutLabel1MouseClicked
        about();
    }//GEN-LAST:event_aboutLabel1MouseClicked

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
       //Τερματισμός εφαρμογής και Entity Manager
       closeApp();
    }//GEN-LAST:event_exitLabelMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        statistics.setVisible(false);
        search.setVisible(false);
        editLists.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

  //Πλαίσιο διαλόγου για το κουμπί ΕΞΟΔΟΣ
    private void closeApp()  {
        Object[] options = {"Yes","No"};
    
    int userOption = JOptionPane.showOptionDialog(new JFrame(),
    "Close Application?","Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    if (userOption == JOptionPane.YES_OPTION)
        con.close();
        System.exit(0);
    }
    
    //Πλαίσιο διαλόγου για το κουμπί About 
    private void about()  {   
    ImageIcon aboutIcon = new ImageIcon("src/main/resources/ProjectIcons/abouticon.png");
    JOptionPane.showMessageDialog( null,
    "Η εφαρμογή δημιουργήθηκε στα πλαίσια\nτης 3ης εργασίας της θεματικής ενότητας\nΠΛΗ24 "
    + "του τμήματος Πληροφορικής του ΕΑΠ\n\nProduct Owner\nΚακαρόντζας Γεώγιος\n\nScrum "
    + "Team\nΑναγνωστόπουλος Βασίλης\nΖησόπουλος Κυριάκος\nΜουμουλίδου Στέλλα"
    + "\n\n                                         Φεβρουάριος 2019","About",
    JOptionPane.INFORMATION_MESSAGE, aboutIcon);
    }
    

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuButton;
    private javax.swing.JLabel aboutLabel1;
    private javax.swing.JMenuItem editItem;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JMenuItem getMoviesItem;
    private javax.swing.JDesktopPane jDesktopPaneMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu popUpMenu;
    private javax.swing.JMenuItem searchItem;
    private javax.swing.JMenuItem statisticsItem;
    // End of variables declaration//GEN-END:variables
}
