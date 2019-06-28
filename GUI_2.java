import java.awt.*;
import java.util.ArrayList;

import Model.Jpotify;
import Model.List;
import Model.Media;
import Model.Music;
import Model.User;
import javafx.stage.FileChooser;

import javax.swing.*;


public class GUI_2 extends javax.swing.JFrame {

    private User user;
    public GUI_2(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {

        window = new javax.swing.JPanel();
        north = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchmusictextfield = new javax.swing.JTextField();
        searchmusicbutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        searchartisttextfield = new javax.swing.JTextField();
        searchartistbutton = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        west = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        favorites = new javax.swing.JButton();
        library = new javax.swing.JButton();
        playlists = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AKS = new javax.swing.JLabel();
        share = new javax.swing.JButton();
        music_pic = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        artwork = new javax.swing.JTextArea();
        addplaylist = new javax.swing.JButton();
        south = new javax.swing.JPanel();
        timebar = new javax.swing.JProgressBar();
        volume = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        play = new javax.swing.JButton();
        forward = new javax.swing.JButton();
        backward = new javax.swing.JButton();
        repeat = new javax.swing.JButton();
        shuffle = new javax.swing.JButton();
        timelabel = new javax.swing.JLabel();
        east = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendlist = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        addfriend = new javax.swing.JButton();
        selectfriend = new javax.swing.JButton();
        center = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        List = new javax.swing.JList<>();
        title = new javax.swing.JLabel();
        addfavorite = new javax.swing.JButton();
        addhare = new javax.swing.JButton();
        addtoplaylist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jpotify");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Jpotify");
        setLayout(new BorderLayout());
        window.setBackground(new java.awt.Color(102, 102, 0));

        north.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30));
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Jpotify");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel5.setForeground(new java.awt.Color(0, 204, 51));
        jLabel5.setText("Search by Music: ");

        searchmusictextfield.setToolTipText("");
        searchmusictextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchmusictextfieldActionPerformed(evt);
            }
        });

        searchmusicbutton.setForeground(new java.awt.Color(0, 204, 51));
        searchmusicbutton.setText("Search");
        searchmusicbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchmusicbuttonMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel6.setForeground(new java.awt.Color(0, 204, 51));
        jLabel6.setText("Search by Artist: ");

        searchartisttextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchartisttextfieldActionPerformed(evt);
            }
        });

        searchartistbutton.setForeground(new java.awt.Color(0, 204, 51));
        searchartistbutton.setText("Search");
        searchartistbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchartistbuttonMouseClicked(evt);
            }
        });
        searchartistbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchartistbuttonActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Tahoma", 0, 18));
        username.setForeground(new java.awt.Color(0, 204, 51));
        username.setText(this.user.getName());
        username.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel7.setForeground(new java.awt.Color(0, 204, 51));
        jLabel7.setText("Username: ");

        javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
        north.setLayout(northLayout);
        northLayout.setHorizontalGroup(
                northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(northLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchmusictextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchmusicbutton)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchartisttextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchartistbutton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        northLayout.setVerticalGroup(
                northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(searchmusictextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchmusicbutton)
                                .addComponent(jLabel6)
                                .addComponent(searchartisttextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchartistbutton)
                                .addComponent(jLabel7)
                                .addComponent(username))
        );

        west.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(0, 204, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText(" add music :");

        browse.setFont(new java.awt.Font("Tahoma", 0, 18));
        browse.setForeground(new java.awt.Color(0, 204, 51));
        browse.setText("Browse");
        browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseMouseClicked(evt);
            }
        });
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        favorites.setBackground(new java.awt.Color(51, 51, 51));
        favorites.setFont(new java.awt.Font("Tahoma", 0, 18));
        favorites.setForeground(new java.awt.Color(0, 204, 51));
        favorites.setText("Favorites");
        favorites.setBorder(null);
        favorites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favoritesMouseClicked(evt);
            }
        });
        favorites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoritesActionPerformed(evt);
            }
        });

        library.setBackground(new java.awt.Color(51, 51, 51));
        library.setFont(new java.awt.Font("Tahoma", 0, 18));
        library.setForeground(new java.awt.Color(0, 204, 51));
        library.setText("Library");
        library.setBorder(null);
        library.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libraryMouseClicked(evt);
            }
        });

        playlists.setBackground(new java.awt.Color(51, 51, 51));
        playlists.setFont(new java.awt.Font("Tahoma", 0, 18));
        playlists.setForeground(new java.awt.Color(0, 204, 51));
        playlists.setText("Playlists");
        playlists.setBorder(null);
        playlists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistsMouseClicked(evt);
            }
        });
        playlists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistsActionPerformed(evt);
            }
        });

        AKS.setIcon(new javax.swing.ImageIcon("spotify (1).png"));
        AKS.setToolTipText("");

        share.setBackground(new java.awt.Color(51, 51, 51));
        share.setFont(new java.awt.Font("Tahoma", 0, 18));
        share.setForeground(new java.awt.Color(0, 204, 51));
        share.setText("Shared PlayList");
        share.setBorder(null);
        share.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        share.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shareMouseClicked(evt);
            }
        });
        share.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shareActionPerformed(evt);
            }
        });

        artwork.setEditable(false);
        artwork.setBackground(new java.awt.Color(51, 51, 51));
        artwork.setColumns(20);
        artwork.setForeground(new java.awt.Color(0, 204, 51));
        artwork.setRows(5);
        artwork.setText("\n\n\n\n");
        jScrollPane3.setViewportView(artwork);

        addplaylist.setBackground(new java.awt.Color(51, 51, 51));
        addplaylist.setFont(new java.awt.Font("Tahoma", 0, 18));
        addplaylist.setForeground(new java.awt.Color(0, 204, 51));
        addplaylist.setText("add Playlist");
        addplaylist.setBorder(null);
        addplaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addplaylistMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout westLayout = new javax.swing.GroupLayout(west);
        west.setLayout(westLayout);
        westLayout.setHorizontalGroup(
                westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(favorites, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(library, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playlists, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(share, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(westLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(browse, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(westLayout.createSequentialGroup()
                                .addContainerGap(45, Short.MAX_VALUE)
                                .addComponent(AKS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(music_pic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addplaylist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        westLayout.setVerticalGroup(
                westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(westLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AKS))
                                .addGroup(westLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(browse))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(library)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playlists)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addplaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(favorites)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(share)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(music_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        share.getAccessibleContext().setAccessibleDescription("");

        south.setBackground(new java.awt.Color(51, 51, 51));

        timebar.setForeground(new java.awt.Color(0, 204, 51));

        volume.setBackground(new java.awt.Color(0, 204, 51));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setForeground(new java.awt.Color(0, 204, 51));
        jLabel4.setText("Volume: ");

        play.setBackground(new java.awt.Color(51, 51, 51));
        play.setIcon(new javax.swing.ImageIcon("play-button.png"));
        play.setBorder(null);
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });

        forward.setBackground(new java.awt.Color(51, 51, 51));
        forward.setIcon(new javax.swing.ImageIcon("play-next-button (1).png"));
        forward.setBorder(null);
        forward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardMouseClicked(evt);
            }
        });
        forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardActionPerformed(evt);
            }
        });

        backward.setBackground(new java.awt.Color(51, 51, 51));
        backward.setIcon(new javax.swing.ImageIcon("backbutoon.png"));
        backward.setBorder(null);
        backward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backwardMouseClicked(evt);
            }
        });

        repeat.setBackground(new java.awt.Color(51, 51, 51));
        repeat.setIcon(new javax.swing.ImageIcon("repeatwh.png"));
        repeat.setBorder(null);
        repeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repeatMouseClicked(evt);
            }
        });

        shuffle.setBackground(new java.awt.Color(51, 51, 51));
        shuffle.setIcon(new javax.swing.ImageIcon("shuffelwh.png"));
        shuffle.setBorder(null);
        shuffle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shuffleMouseClicked(evt);
            }
        });

        timelabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        timelabel.setForeground(new java.awt.Color(0, 204, 51));
        timelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timelabel.setText("00:00/00:00");

        javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
        south.setLayout(southLayout);
        southLayout.setHorizontalGroup(
                southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(southLayout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addGroup(southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(southLayout.createSequentialGroup()
                                                .addComponent(timebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(southLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                                                .addComponent(shuffle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(backward, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(forward, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(repeat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(178, 178, 178)
                                                .addComponent(timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(232, 232, 232))))
        );
        southLayout.setVerticalGroup(
                southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(southLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(southLayout.createSequentialGroup()
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)
                                                        .addGroup(southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(play, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(forward, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(backward, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(repeat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(shuffle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(southLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        east.setBackground(new java.awt.Color(51, 51, 51));

        friendlist.setBackground(new java.awt.Color(51, 51, 51));
        friendlist.setForeground(new java.awt.Color(0, 204, 51));
        friendlist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(friendlist);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel8.setForeground(new java.awt.Color(0, 204, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Friend Activity");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setRequestFocusEnabled(false);
        jLabel8.setVerifyInputWhenFocusTarget(false);

        addfriend.setBackground(new java.awt.Color(51, 51, 51));
        addfriend.setFont(new java.awt.Font("Tahoma", 0, 18));
        addfriend.setForeground(new java.awt.Color(0, 204, 51));
        addfriend.setText("add Friend");
        addfriend.setBorder(null);
        addfriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addfriendMouseClicked(evt);
            }
        });

        selectfriend.setFont(new java.awt.Font("Tahoma", 0, 14));
        selectfriend.setForeground(new java.awt.Color(0, 204, 51));
        selectfriend.setText("select");
        selectfriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectfriendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout eastLayout = new javax.swing.GroupLayout(east);
        east.setLayout(eastLayout);
        eastLayout.setHorizontalGroup(
                eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addfriend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectfriend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eastLayout.setVerticalGroup(
                eastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(eastLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectfriend)
                                .addGap(14, 14, 14)
                                .addComponent(addfriend)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        center.setBackground(new java.awt.Color(51, 51, 51));

        List.setBackground(new java.awt.Color(51, 51, 51));
        List.setFont(new java.awt.Font("Tahoma", 0, 14));
        List.setForeground(new java.awt.Color(0, 204, 51));
        List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(List);

        title.setFont(new java.awt.Font("Tahoma", 0, 18));
        title.setForeground(new java.awt.Color(0, 204, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("list's name");

        addfavorite.setForeground(new java.awt.Color(0, 204, 51));
        addfavorite.setText("add to favorites");
        addfavorite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addfavoriteMouseClicked(evt);
            }
        });
        addfavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addfavoriteActionPerformed(evt);
            }
        });

        addhare.setForeground(new java.awt.Color(0, 204, 51));
        addhare.setText("add to shared list");
        addhare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addhareMouseClicked(evt);
            }
        });

        addtoplaylist.setForeground(new java.awt.Color(0, 204, 51));
        addtoplaylist.setText("add to playlist");
        addtoplaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addtoplaylistMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(centerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(centerLayout.createSequentialGroup()
                                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(centerLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(addtoplaylist)
                                .addGap(29, 29, 29)
                                .addComponent(addfavorite)
                                .addGap(30, 30, 30)
                                .addComponent(addhare)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        centerLayout.setVerticalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addfavorite)
                                        .addComponent(addhare)
                                        .addComponent(addtoplaylist)))
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
        ImageIcon img = new ImageIcon("spotify (1).png");
        setIconImage(img.getImage());
    }// </editor-fold>

    private void playlistsActionPerformed(java.awt.event.ActionEvent evt) {
        String[] names = new String[user.getLibrary().getPlayList().size()];
        ArrayList<Model.List> lists = user.getLibrary().getPlayList();
        for(int i = 0; i < user.getLibrary().getPlayList().size(); i++ ) {
            names[i] = lists.get(i).getName();
        }
        List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = names;
            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int index) {
                return strings[index];
            }

        });
        title.setText("PlayLists");
    }

    private void favoritesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void browseMouseClicked(java.awt.event.MouseEvent evt) {
        GUI_3 GUI_3 = new GUI_3();
    }

    private void searchmusictextfieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void searchartisttextfieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void searchartistbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void forwardActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void shareActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    public int playButtonStatus=0;
    private void playMouseClicked(java.awt.event.MouseEvent evt) {
        if (playButtonStatus==0)
        {
            playButtonStatus=1;
            play.setIcon(new javax.swing.ImageIcon("pause-button.png"));
            play.setBorder(null);
        }
        else {
            playButtonStatus=0;
            play.setIcon(new javax.swing.ImageIcon("play-button.png"));
            play.setBorder(null);
        }

    }

    private void addfavoriteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addplaylistMouseClicked(java.awt.event.MouseEvent evt) {
        GUI_4 GUI_4 = new GUI_4(user);
    }

    private void addtoplaylistMouseClicked(java.awt.event.MouseEvent evt) {
        GUI_5 GUI_5 = new GUI_5();
    }

    private void addfavoriteMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void addhareMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void shareMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void favoritesMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void playlistsMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void libraryMouseClicked(java.awt.event.MouseEvent evt) {
        String[] names = new String[user.getLibrary().getMedium().size()];
        ArrayList<Media> musics = user.getLibrary().getMedium();
        for(int i = 0; i < user.getLibrary().getMedium().size(); i++ ) {
            names[i] = musics.get(i).getName();
        }
        List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = names;
            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int index) {
                return strings[index];
            }

        });
        title.setText("Library");
    }

    private void searchmusicbuttonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void searchartistbuttonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void selectfriendMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void addfriendMouseClicked(java.awt.event.MouseEvent evt) {
        GUI_6 GUI6 = new GUI_6();
    }

    private void forwardMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void backwardMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }
    public int repeatButtonStatus=0;
    private void repeatMouseClicked(java.awt.event.MouseEvent evt) {

            if (repeatButtonStatus==0)
            {
                repeatButtonStatus=1;
                repeat.setIcon(new javax.swing.ImageIcon("repeat.png"));
                repeat.setBorder(null);
            }
            else {
                repeatButtonStatus=0;
                repeat.setIcon(new javax.swing.ImageIcon("repeatwh.png"));
                repeat.setBorder(null);
            }


    }
    public int shuffleButtonStatus=0;
    private void shuffleMouseClicked(java.awt.event.MouseEvent evt) {
        if (shuffleButtonStatus==0)
        {
            shuffleButtonStatus=1;
            shuffle.setIcon(new javax.swing.ImageIcon("shuffel.png"));
            shuffle.setBorder(null);
        }
        else {
            shuffleButtonStatus=0;
            shuffle.setIcon(new javax.swing.ImageIcon("shuffelwh.png"));
            shuffle.setBorder(null);
        }
    }

    private javax.swing.JLabel AKS;
    private javax.swing.JList<String> List;
    private javax.swing.JButton addfavorite;
    private javax.swing.JButton addfriend;
    private javax.swing.JButton addhare;
    private javax.swing.JButton addplaylist;
    private javax.swing.JButton addtoplaylist;
    private javax.swing.JTextArea artwork;
    private javax.swing.JButton backward;
    private javax.swing.JButton browse;
    private javax.swing.JPanel center;
    private javax.swing.JPanel east;
    private javax.swing.JButton favorites;
    private javax.swing.JButton forward;
    private javax.swing.JList<String> friendlist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton library;
    private javax.swing.JLabel music_pic;
    private javax.swing.JPanel north;
    private javax.swing.JButton play;
    private javax.swing.JButton playlists;
    private javax.swing.JButton repeat;
    private javax.swing.JButton searchartistbutton;
    private javax.swing.JTextField searchartisttextfield;
    private javax.swing.JButton searchmusicbutton;
    private javax.swing.JTextField searchmusictextfield;
    private javax.swing.JButton selectfriend;
    private javax.swing.JButton share;
    private javax.swing.JButton shuffle;
    private javax.swing.JPanel south;
    private javax.swing.JProgressBar timebar;
    private javax.swing.JLabel timelabel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel username;
    private javax.swing.JSlider volume;
    private javax.swing.JPanel west;
    private javax.swing.JPanel window;
}

