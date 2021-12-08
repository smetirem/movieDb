
package views;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StatisticsWrapper extends javax.swing.JInternalFrame {

    EntityManager con = MainMenuWrapper.con;
    controllers.Movie movieContr = new controllers.Movie();
    controllers.FavoriteList listsContr = new controllers.FavoriteList();
    
    public StatisticsWrapper() {
        initComponents();
        //Απόκρυψη κεντρικής μπάρας του internalJFrame
       ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);   
        resultsTable.setAutoCreateRowSorter(true);
        resultsTable.setRowHeight(25);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        myMoviesPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("myMoviesPU").createEntityManager();
        favoriteListQuery = java.beans.Beans.isDesignTime() ? null : myMoviesPUEntityManager.createQuery("SELECT f FROM FavoriteList f");
        favoriteListList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : favoriteListQuery.getResultList();
        jToolBarEdit4 = new javax.swing.JToolBar();
        bestMoviesOfAll = new javax.swing.JButton();
        bestMoviesPerList = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setBackground(new java.awt.Color(104, 115, 145));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        setPreferredSize(new java.awt.Dimension(843, 536));

        jToolBarEdit4.setBackground(new java.awt.Color(204, 204, 204));
        jToolBarEdit4.setBorder(null);
        jToolBarEdit4.setFloatable(false);
        jToolBarEdit4.setRollover(true);
        jToolBarEdit4.setMargin(new java.awt.Insets(0, 10, 10, 0));
        jToolBarEdit4.setMinimumSize(new java.awt.Dimension(50, 25));
        jToolBarEdit4.setPreferredSize(new java.awt.Dimension(50, 25));

        bestMoviesOfAll.setBackground(new java.awt.Color(255, 255, 255));
        bestMoviesOfAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bestMoviesOfAll.setForeground(new java.awt.Color(102, 102, 0));
        bestMoviesOfAll.setText("Οι Καλύτερες 10 Τανίες");
        bestMoviesOfAll.setBorder(null);
        bestMoviesOfAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bestMoviesOfAll.setFocusable(false);
        bestMoviesOfAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bestMoviesOfAll.setMargin(new java.awt.Insets(0, 10, 0, 10));
        bestMoviesOfAll.setMaximumSize(new java.awt.Dimension(180, 40));
        bestMoviesOfAll.setMinimumSize(new java.awt.Dimension(80, 40));
        bestMoviesOfAll.setOpaque(false);
        bestMoviesOfAll.setPreferredSize(new java.awt.Dimension(180, 40));
        bestMoviesOfAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bestMoviesOfAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestMoviesOfAllActionPerformed(evt);
            }
        });
        jToolBarEdit4.add(bestMoviesOfAll);

        bestMoviesPerList.setBackground(new java.awt.Color(255, 255, 255));
        bestMoviesPerList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bestMoviesPerList.setForeground(new java.awt.Color(102, 102, 0));
        bestMoviesPerList.setText("Οι Καλύτερες ταινίες ανά λίστα");
        bestMoviesPerList.setBorder(null);
        bestMoviesPerList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bestMoviesPerList.setFocusable(false);
        bestMoviesPerList.setHideActionText(true);
        bestMoviesPerList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bestMoviesPerList.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        bestMoviesPerList.setMargin(new java.awt.Insets(0, 10, 0, 10));
        bestMoviesPerList.setMaximumSize(new java.awt.Dimension(220, 280));
        bestMoviesPerList.setMinimumSize(new java.awt.Dimension(80, 40));
        bestMoviesPerList.setName(""); // NOI18N
        bestMoviesPerList.setOpaque(false);
        bestMoviesPerList.setPreferredSize(new java.awt.Dimension(180, 40));
        bestMoviesPerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestMoviesPerListActionPerformed(evt);
            }
        });
        jToolBarEdit4.add(bestMoviesPerList);

        clear.setBackground(new java.awt.Color(204, 204, 204));
        clear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(102, 102, 0));
        clear.setText("Καθαρισμός");
        clear.setBorder(null);
        clear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clear.setOpaque(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jToolBarEdit4.add(clear);

        resultsTable.setBackground(new java.awt.Color(255, 255, 204));
        resultsTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        resultsTable.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        resultsTable.setForeground(new java.awt.Color(102, 102, 102));
        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Τίτλος Ταινίας", "Βαθμολογία"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultsTable.setAlignmentX(1.0F);
        resultsTable.setAlignmentY(1.0F);
        resultsTable.setGridColor(new java.awt.Color(255, 255, 204));
        resultsTable.setIntercellSpacing(new java.awt.Dimension(2, 2));
        resultsTable.setRequestFocusEnabled(false);
        resultsTable.setSelectionBackground(new java.awt.Color(153, 204, 255));
        resultsTable.setSelectionForeground(new java.awt.Color(255, 255, 153));
        jScrollPane1.setViewportView(resultsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addComponent(jToolBarEdit4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jToolBarEdit4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bestMoviesPerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestMoviesPerListActionPerformed
        //Ευρεση όλων των λιστών που υπάρχουν στη βάση δεδομένων
        List<models.FavoriteList> allLists = listsContr.getAllLists(con);
        if (!(allLists.isEmpty())){
        //Για κάθε λίστα έρχεται η ταινία με την υψυλότερη βαθμολογία σε κατάλληλη λίστα
        List<models.Movie> bestMoviePerList = new ArrayList<>();
            for (models.FavoriteList l : allLists) {  
                if (!(l.getMovieCollection().isEmpty()))
                bestMoviePerList.add(movieContr.getBestMoviePerList(con, l.getName()));  
            }
            // Εμφάνιση αποτελεσμάτων στο πίνακα
            clearTable(resultsTable);
            showTable(bestMoviePerList, resultsTable);
    }//GEN-LAST:event_bestMoviesPerListActionPerformed
    }

    
    private void bestMoviesOfAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestMoviesOfAllActionPerformed
        List<models.Movie> list = movieContr.getBestMovies(con);
        if (!(list.isEmpty())){
        clearTable(resultsTable);
        showTable(list, resultsTable);
    }//GEN-LAST:event_bestMoviesOfAllActionPerformed
    }
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
         clearTable(resultsTable);
    }//GEN-LAST:event_clearActionPerformed

    //Μέθοδος που εμφανίζει δεδομένα από λίστα σε πίνακα
    private void showTable(List<models.Movie> list, JTable table){

    DefaultTableModel tModel = (DefaultTableModel) table.getModel();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );

    String[] ob = new String[50];
       tModel.setRowCount(0);
       table.getColumnModel().getColumn(0).setMinWidth(310);
       table.getColumnModel().getColumn(1).setMinWidth(150);
    for (int i = 0; i < list.size(); i++){
        {ob[0] = list.get(i).getTitle();
         ob[1] = list.get(i).getVoteAverage().toString();
         tModel.addRow(ob);}
        }
    }

    //Μέθοδος που διαγράφει τις εγγραφές ενός πίνακα
    public void clearTable(JTable table){
    DefaultTableModel model = (DefaultTableModel)table.getModel();
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged(); // notifies the JTable that the model has changed
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bestMoviesOfAll;
    private javax.swing.JButton bestMoviesPerList;
    private javax.swing.JButton clear;
    private java.util.List<models.FavoriteList> favoriteListList;
    private javax.persistence.Query favoriteListQuery;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBarEdit4;
    private javax.persistence.EntityManager myMoviesPUEntityManager;
    private javax.swing.JTable resultsTable;
    // End of variables declaration//GEN-END:variables
}
