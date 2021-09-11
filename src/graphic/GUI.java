package graphic;

import model.Music;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GUI {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private final JFrame MAIN_PANEL;
    private final Dimension MAIN_PANEL_DIMENSION = new Dimension(screenSize.width, screenSize.height- 100);
    private final Point MAIN_PANEL_POINT = new Point(0, 0);

    private final String BACKGROUND_PANEL = "backgroundPanel.jpg";
    private final String MAIN_BACKGROUND_PANEL = "mainBackgroundPanel.jpg";

    private final Dimension MUSIC_LIST_PANEL_DIMENSION = new Dimension(
            MAIN_PANEL_DIMENSION.width/4,
            MAIN_PANEL_DIMENSION.height*2/3
    );
    private final Dimension CONTROL_MUSIC_PANEL_DIMENSION = new Dimension(
            MAIN_PANEL_DIMENSION.width,
            MAIN_PANEL_DIMENSION.height/3
    );
    private final Dimension MONITORING_PANEL_DIMENSION = new Dimension(
            MAIN_PANEL_DIMENSION.width*3/4,
            MAIN_PANEL_DIMENSION.height*2/3
    );

    public GUI() {
        MAIN_PANEL = prepareMainFrame();
        addPanelToMainPanel();
        MAIN_PANEL.validate();

        String srt1 = "javax.swing.plaf.metal.MetalLookAndFeel";
        String srt2 = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        String srt3 = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        String srt4 = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
        String srt5 = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        String srt6 = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

        try {
            UIManager.setLookAndFeel(srt3);
            SwingUtilities.updateComponentTreeUI(MAIN_PANEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        MAIN_PANEL.setVisible(true);

    }

    private JFrame prepareMainFrame() {
        JFrame mainFrame = new JFrame("Music Player");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(MAIN_PANEL_DIMENSION);
        mainFrame.setLocation(MAIN_PANEL_POINT);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return mainFrame;
    }

    private JPanel prepareMusicListPanel() {
        // prepare panel
        JPanel musicJListPanel = createCustomizedPanel();

        GridBagConstraints gridTemp = createDefaultGridBagConstraints();

        musicJListPanel.setLayout(new GridBagLayout());

//        JList<Music> musicJList = createJList();
        JList<String> musicJList = createJList();
        String[] names = new String[30];
        Formatter fm = new Formatter();
        for (int i = 0; i < 30 ; ++i) {
            names[i] = "name"+ i;
        }
        musicJList.setListData(names);

        JLabel label = new JLabel(fm.format("%-20s, %-20s, %-20s","Title", "Name", "Time").toString());
        label.setMinimumSize(new Dimension(MUSIC_LIST_PANEL_DIMENSION.width,
                MUSIC_LIST_PANEL_DIMENSION.height/3));

        JPanel panel = createCustomizedPanel();
        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setLayout(new BorderLayout());
        panel.add(musicJList, BorderLayout.CENTER);

        JScrollPane musicJScroll = new JScrollPane(panel);
        musicJScroll.setBorder(createEtchedAndBevelBorder());
        musicJScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        musicJScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        musicJScroll.setMinimumSize(MUSIC_LIST_PANEL_DIMENSION);

        gridTemp.gridheight = 1;
        gridTemp.anchor = GridBagConstraints.LINE_START;
        gridTemp.gridy = 0;
        musicJListPanel.add(label, gridTemp);

        gridTemp.gridheight = 2;
        gridTemp.gridy = 1;
        musicJListPanel.add(musicJScroll, gridTemp);

        return musicJListPanel;
    }

    private JPanel prepareControlMusicPanel() {
        // prepare panel
        JPanel controlMusicPanel = createCustomizedPanel();
        controlMusicPanel.setLayout(new GridBagLayout());

        // Grid
        GridBagConstraints gridTemp = createDefaultGridBagConstraints();

        // JLabel
        JLabel coverLabel = new JLabel(new ImageIcon("test.jpg"));
        try {
            BufferedImage cover = ImageIO.read(new File("test.jpg"));
            Image coverImage = cover.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

            coverLabel = new JLabel(new ImageIcon(coverImage));
            coverLabel.setPreferredSize(new Dimension(200, 200));


        } catch (IOException e) {
            e.printStackTrace();
        }
        coverLabel.setPreferredSize(new Dimension(200, 200));
//        coverLabel.setMinimumSize(new Dimension(200, 200));


        JPanel infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setBackground(Color.orange);

        // Music info
        JLabel title = createInfoLabel("title");
        JLabel artist = createInfoLabel("artist");
        JLabel album = createInfoLabel("album");
        JLabel time = createInfoLabel("time");
        JLabel year = createInfoLabel("year");

        ArrayList<JLabel> infoList = new ArrayList<>(List.of(title, artist, album, time, year));


        gridTemp.fill = GridBagConstraints.NONE;
        gridTemp.anchor = GridBagConstraints.LINE_END;

        gridTemp.gridx = 1;
        gridTemp.gridy = 0;
        gridTemp.weightx = 1;

        controlMusicPanel.add(prepareControlButtonPanel(), gridTemp);

        gridTemp.gridx = 0;
        gridTemp.gridy = 0;


        gridTemp.anchor = GridBagConstraints.PAGE_START;
        infoPanel.add(title, gridTemp);

        gridTemp.gridy = 1;
        infoPanel.add(artist, gridTemp);



        JPanel match = new JPanel(new GridBagLayout());

        gridTemp.gridx = 1;
        gridTemp.gridy = 0;
        gridTemp.anchor = GridBagConstraints.PAGE_START;

        for (int y = 0; y < 5; ++y) {
            gridTemp.gridy = y;
            match.add(infoList.get(y), gridTemp);
        }

        gridTemp.gridy = 0;
        gridTemp.gridx = 0;
        gridTemp.gridheight = 5;
        match.add(coverLabel, gridTemp);
        gridTemp.gridheight = 1;

        gridTemp.gridx = 0;
        gridTemp.gridy = 0;
        gridTemp.anchor = GridBagConstraints.LINE_START;

        controlMusicPanel.add(match, gridTemp);



        return controlMusicPanel;
    }

    private JPanel prepareControlButtonPanel() {
        JPanel controlButton = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel();

        Dimension controlButtonDimension = new Dimension(MAIN_PANEL_DIMENSION.width, 200);


        GridBagConstraints gridTemp = createDefaultGridBagConstraints();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));


        // JButtons
        JButton start = new JButton("start");
        JButton forward = new JButton("forward");
        JButton backward = new JButton("backward");
        JButton shuffle = new JButton("shf");
        JButton repeat = new JButton("rpt");

        start.setPreferredSize(new Dimension(100, 30));
        backward.setPreferredSize(new Dimension(100, 30));
        forward.setPreferredSize(new Dimension(100, 30));
        shuffle.setPreferredSize(new Dimension(30, 30));
        repeat.setPreferredSize(new Dimension(30, 30));

        buttonPanel.add(shuffle);
        buttonPanel.add(repeat);
        buttonPanel.add(start);
        buttonPanel.add(forward);
        buttonPanel.add(backward);

        JSlider volumeSlider = new JSlider(0,100, 0);
        volumeSlider.setPreferredSize(new Dimension(100, 40));
        volumeSlider.setMinimumSize(new Dimension(100, 40));
        volumeSlider.setMaximumSize(new Dimension(100, 40));

        buttonPanel.add(volumeSlider);


        // time JSliders
        JSlider timeSlider = new JSlider(0,100, 0);
        timeSlider.setPreferredSize(new Dimension(MAIN_PANEL_DIMENSION.width - 500, 30));
        timeSlider.setMinimumSize(new Dimension(MAIN_PANEL_DIMENSION.width - 500, 30));
        timeSlider.setMaximumSize(new Dimension(MAIN_PANEL_DIMENSION.width, 30));


        gridTemp.fill = GridBagConstraints.NONE;
        gridTemp.anchor = GridBagConstraints.CENTER;

        gridTemp.gridx = 0;
        gridTemp.gridy = 0;
        gridTemp.gridwidth = 1;
        controlButton.add(timeSlider, gridTemp);

        gridTemp.gridx = 0;
        gridTemp.gridy = 1;
        gridTemp.gridwidth = 1;
        controlButton.add(buttonPanel, gridTemp);

        return controlButton;
    }

    private JPanel prepareMonitoringPanel() {

        JPanel musicsLabelPanel = createMusicLabel(50, new ArrayList<>());

        JScrollPane jMonScroll = new JScrollPane(musicsLabelPanel);
        jMonScroll.setBorder(createEtchedAndBevelBorder());
        jMonScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jMonScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jMonScroll.setMinimumSize(MONITORING_PANEL_DIMENSION);

        JPanel panel = createCustomizedPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jMonScroll, BorderLayout.CENTER);

        return panel;
    }

    public JFrame getMAIN_PANEL() {
        return MAIN_PANEL;
    }

    private void addPanelToMainPanel() {
        JPanel monitoringPanel = prepareMonitoringPanel();
        JPanel musicListPanel = prepareMusicListPanel();
        JPanel controlMusicPanel = prepareControlMusicPanel();

        musicListPanel.setPreferredSize(MUSIC_LIST_PANEL_DIMENSION);
        musicListPanel.setMinimumSize(MUSIC_LIST_PANEL_DIMENSION);

        monitoringPanel.setPreferredSize(MONITORING_PANEL_DIMENSION);
        monitoringPanel.setMaximumSize(MONITORING_PANEL_DIMENSION);

        controlMusicPanel.setPreferredSize(CONTROL_MUSIC_PANEL_DIMENSION);
        controlMusicPanel.setMaximumSize(CONTROL_MUSIC_PANEL_DIMENSION);

        MAIN_PANEL.add(monitoringPanel, BorderLayout.CENTER);
        MAIN_PANEL.add(musicListPanel, BorderLayout.EAST);
        MAIN_PANEL.add(controlMusicPanel, BorderLayout.SOUTH);
    }

    private JPanel createMusicLabel(int numberOfMusicLabel, List<Music> musics) {

        GridBagConstraints gridTemp = createDefaultGridBagConstraints();
        JPanel musicsLabelPanel = createCustomizedPanel();
        musicsLabelPanel.setLayout(new GridBagLayout());


        try {
            Image image = ImageIO.read(new File(BACKGROUND_PANEL));
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(200,200, Image.SCALE_DEFAULT));

            Dimension elementDimension = new Dimension(
                    200,
                    200
            );
            JLabel[] buttons = new JLabel[numberOfMusicLabel];

            for (int i = 0; i < numberOfMusicLabel; ++i) {
                buttons[i] = new JLabel(imageIcon);
                buttons[i].setPreferredSize(elementDimension);
                buttons[i].setMinimumSize(elementDimension);
                buttons[i].setMaximumSize(elementDimension);
            }

            int y = 0;
            int x = 0;
            gridTemp.anchor = GridBagConstraints.CENTER;
            gridTemp.insets = new Insets(10,10, 10, 10);
            for (JLabel b :
                    buttons) {
                gridTemp.gridx = x % 6;
                gridTemp.gridy = y;

                musicsLabelPanel.add(b, gridTemp);
                if ( (x%6) == 5 ) ++y;

                ++x;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return musicsLabelPanel;
    }

    private JLabel createInfoLabel(String txt) {
        JLabel label = new JLabel('<' + txt + '>');

        label.setPreferredSize(new Dimension(200, 40));
        label.setMinimumSize(new Dimension(200, 40));

        label.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        return label;
    }

    private <T> JList<T> createJList() {
        JList<T> list = new JList<>();

        list.setBackground(Color.gray);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        Border linedBorder = BorderFactory.createLoweredBevelBorder();
        list.setBorder(linedBorder);

        return list;
    }

    private GridBagConstraints createDefaultGridBagConstraints() {
        return new GridBagConstraints(0, 0,
                1, 1,
                1, 1,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                new Insets(0,0,0,0),
                0, 0
        );
    }

    private Border createEtchedAndBevelBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                BorderFactory.createBevelBorder(BevelBorder.RAISED)
        );
    }

    private JPanel createCustomizedPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBorder(createEtchedAndBevelBorder());
        jPanel.setBackground(Color.gray);

        return jPanel;
    }
}
