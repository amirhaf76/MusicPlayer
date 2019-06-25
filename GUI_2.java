
import java.awt.Image;
import java.awt.Toolkit;
import javafx.stage.FileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;


public class GUI_2 extends javax.swing.JFrame {

    public void setIcon(JComponent com,String picPath,int i)
    {
        ImageIcon im2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(picPath)));

        Image image1 = im2.getImage();
        Image image2 = image1.getScaledInstance(com.getWidth(),com.getHeight(),Image.SCALE_DEFAULT);
        ImageIcon finalimg = new ImageIcon(image2);
        switch (i){
            case 0:
                JButton jb = (JButton) com;
                jb.setIcon(finalimg);

                break;

            case 1:
                JLabel j1 = (JLabel) com;
                j1.setIcon(finalimg);
                break;

        }


    }



    public GUI_2() {
        initComponents();
    }


    private void initComponents() {

        window = new javax.swing.JPanel();
        north = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchmusicA = new javax.swing.JTextField();
        searchmusicB = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        searchartA = new javax.swing.JTextField();
        searchartB = new javax.swing.JButton();
        Username = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        west = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Browse = new javax.swing.JButton();
        Favorites = new javax.swing.JButton();
        Library = new javax.swing.JButton();
        Playlists = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AKS = new javax.swing.JLabel();
        Aksalbum = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Artwork = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        south = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSlider1 = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        Play = new javax.swing.JButton();
        forward = new javax.swing.JButton();
        Backward = new javax.swing.JButton();
        repeat = new javax.swing.JButton();
        Shufel = new javax.swing.JButton();
        east = new javax.swing.JPanel();
        Friend = new javax.swing.JButton();
        center = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jpotify");
        setName("Jpotify"); // NOI18N

        window.setBackground(new java.awt.Color(102, 102, 0));

        north.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Jpotify");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 51));
        jLabel5.setText("Search by Music: ");

        searchmusicA.setToolTipText("");
        searchmusicA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchmusicAActionPerformed(evt);
            }
        });

        searchmusicB.setForeground(new java.awt.Color(0, 204, 51));
        searchmusicB.setText("ٍSearch");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 51));
        jLabel6.setText("Search by Artist: ");

        searchartA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchartAActionPerformed(evt);
            }
        });

        searchartB.setForeground(new java.awt.Color(0, 204, 51));
        searchartB.setText("Search");
        searchartB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchartBActionPerformed(evt);
            }
        });

        Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Username.setForeground(new java.awt.Color(0, 204, 51));
        Username.setText("AminRezai2000");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 51));
        jLabel7.setText("Username: ");

        javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
        north.setLayout(northLayout);
        northLayout.setHorizontalGroup(
                northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(northLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(236, 236, 236)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchmusicA, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchmusicB)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchartA, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchartB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        northLayout.setVerticalGroup(
                northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(searchmusicA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchmusicB)
                                .addComponent(jLabel6)
                                .addComponent(searchartA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchartB)
                                .addComponent(jLabel7)
                                .addComponent(Username))
        );

        west.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(0, 204, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText(" add music :");

        Browse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Browse.setForeground(new java.awt.Color(0, 204, 51));
        Browse.setText("Browse");
        Browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrowseMouseClicked(evt);
            }
        });
        Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseActionPerformed(evt);
            }
        });

        Favorites.setBackground(new java.awt.Color(51, 51, 51));
        Favorites.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Favorites.setForeground(new java.awt.Color(0, 204, 51));
        Favorites.setText("Favorits");
        Favorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FavoritesActionPerformed(evt);
            }
        });

        Library.setBackground(new java.awt.Color(51, 51, 51));
        Library.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Library.setForeground(new java.awt.Color(0, 204, 51));
        Library.setText("Library");

        Playlists.setBackground(new java.awt.Color(51, 51, 51));
        Playlists.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Playlists.setForeground(new java.awt.Color(0, 204, 51));
        Playlists.setText("Playlists");
        Playlists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaylistsActionPerformed(evt);
            }
        });

        Artwork.setBackground(new java.awt.Color(51, 51, 51));
        Artwork.setColumns(20);
        Artwork.setForeground(new java.awt.Color(0, 204, 51));
        Artwork.setRows(5);
        jScrollPane1.setViewportView(Artwork);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 51));
        jButton2.setText("ShareList");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout westLayout = new javax.swing.GroupLayout(west);
        west.setLayout(westLayout);
        westLayout.setHorizontalGroup(
                westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Favorites, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Library, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(westLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Browse)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(Playlists, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(westLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Aksalbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(westLayout.createSequentialGroup()
                                                .addComponent(AKS, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        westLayout.setVerticalGroup(
                westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(westLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AKS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(Browse))
                                .addGap(11, 11, 11)
                                .addComponent(Library)
                                .addGap(18, 18, 18)
                                .addComponent(Playlists)
                                .addGap(18, 18, 18)
                                .addComponent(Favorites)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(Aksalbum, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        south.setBackground(new java.awt.Color(51, 51, 51));

        jSlider1.setBackground(new java.awt.Color(0, 204, 51));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 51));
        jLabel4.setText("Volume: ");

        forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
        south.setLayout(southLayout);
        southLayout.setHorizontalGroup(
                southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(southLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(southLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(190, 190, 190)
                                                .addComponent(Shufel)
                                                .addGap(18, 18, 18)
                                                .addComponent(Backward)
                                                .addGap(18, 18, 18)
                                                .addComponent(Play)
                                                .addGap(18, 18, 18)
                                                .addComponent(forward)
                                                .addGap(18, 18, 18)
                                                .addComponent(repeat)
                                                .addGap(0, 441, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        southLayout.setVerticalGroup(
                southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(southLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addGroup(southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(forward, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Backward, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(repeat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Shufel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        east.setBackground(new java.awt.Color(51, 51, 51));

        Friend.setBackground(new java.awt.Color(51, 51, 51));
        Friend.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Friend.setForeground(new java.awt.Color(0, 204, 51));
        Friend.setText("Friend Activity");

        javax.swing.GroupLayout eastLayout = new javax.swing.GroupLayout(east);
        east.setLayout(eastLayout);
        eastLayout.setHorizontalGroup(
                eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Friend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eastLayout.setVerticalGroup(
                eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eastLayout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(Friend)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        center.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1083, Short.MAX_VALUE)
        );
        centerLayout.setVerticalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout windowLayout = new javax.swing.GroupLayout(window);
        window.setLayout(windowLayout);
        windowLayout.setHorizontalGroup(
                windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(windowLayout.createSequentialGroup()
                                .addComponent(west, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(south, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(east, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(north, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        windowLayout.setVerticalGroup(
                windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(windowLayout.createSequentialGroup()
                                .addComponent(north, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(windowLayout.createSequentialGroup()
                                                .addComponent(center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(south, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(west, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(east, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocation(175,100);
        setVisible(true);
    }

    private void PlaylistsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void FavoritesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BrowseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BrowseMouseClicked(java.awt.event.MouseEvent evt) {
        final FileChooser filec = new FileChooser();
        //filec.showOpenDialog();
    }

    private void searchmusicAActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void searchartAActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void searchartBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void forwardActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private javax.swing.JLabel AKS;
    private javax.swing.JLabel Aksalbum;
    private javax.swing.JTextArea Artwork;
    private javax.swing.JButton Backward;
    private javax.swing.JButton Browse;
    private javax.swing.JButton Favorites;
    private javax.swing.JButton Library;
    private javax.swing.JButton Play;
    private javax.swing.JButton Playlists;
    private javax.swing.JButton Shufel;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel center;
    private javax.swing.JPanel east;
    private javax.swing.JButton forward;
    private javax.swing.JButton Friend;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JPanel north;
    private javax.swing.JButton repeat;
    private javax.swing.JTextField searchartA;
    private javax.swing.JButton searchartB;
    private javax.swing.JTextField searchmusicA;
    private javax.swing.JButton searchmusicB;
    private javax.swing.JPanel south;
    private javax.swing.JPanel west;
    private javax.swing.JPanel window;
}
