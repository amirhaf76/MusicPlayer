package graphic;

import model.Music;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private final JFrame MAIN_PANEL;
    private final Dimension MAIN_PANEL_DIMENSION = new Dimension(screenSize.width, screenSize.height- 100);
    private final Point MAIN_PANEL_POINT = new Point(0, 0);

    private final Dimension MUSIC_LIST_PANEL_DIMENSION = new Dimension(
            MAIN_PANEL_DIMENSION.width/3,
            MAIN_PANEL_DIMENSION.height*2/3
    );
    private final Dimension CONTROL_MUSIC_PANEL_DIMENSION = new Dimension(
            MAIN_PANEL_DIMENSION.width,
            MAIN_PANEL_DIMENSION.height/3
    );
    private final Dimension MONITORING_PANEL_DIMENSION = new Dimension(
            MAIN_PANEL_DIMENSION.width*2/3,
            MAIN_PANEL_DIMENSION.height*2/3
    );

    public GUI() {
        MAIN_PANEL = prepareMainFrame();
        addPanelToMainPanel();
        MAIN_PANEL.validate();
        MAIN_PANEL.setVisible(true);

    }

    private JFrame prepareMainFrame() {
        JFrame tempFrame = new JFrame("Music Player");

        tempFrame.setLayout(new BorderLayout());
        tempFrame.setSize(MAIN_PANEL_DIMENSION);
        tempFrame.setLocation(MAIN_PANEL_POINT);
        tempFrame.setResizable(false);
        tempFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return tempFrame;
    }

    private JPanel prepareMusicListPanel() {
        // prepare panel
        JPanel musicJListPanel = createCustomizedPanel();
        musicJListPanel.setLayout(new GridBagLayout());

        GridBagConstraints gridTemp = createDefaultGridBagConstraints();

        JList<Music> musicJList = createJList();

        musicJListPanel.add(musicJList, gridTemp);

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

    public JFrame getMAIN_PANEL() {
        return MAIN_PANEL;
    }

    private void addPanelToMainPanel() {
        JPanel monitoringPanel = prepareControlMusicPanel();
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

    private JLabel createInfoLabel(String txt) {
        JLabel label = new JLabel('<' + txt + '>');

        label.setPreferredSize(new Dimension(200, 40));
        label.setMinimumSize(new Dimension(200, 40));

        label.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        return label;
    }

    private Border createBorder() {

        return BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                BorderFactory.createBevelBorder(BevelBorder.RAISED)
        );
    }

    private <T> JList<T> createJList(int width , int height) {
        JList<T> list = new JList<>();

        Dimension listDimension = new Dimension(width, height);

        list.setBackground(Color.gray);

        list.setPreferredSize(listDimension);
        list.setMinimumSize(listDimension);
        list.setMaximumSize(listDimension);

        Border linedBorder = BorderFactory.createLoweredBevelBorder();
        Border titledBorder = BorderFactory.createTitledBorder(linedBorder,
                "Music List",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.TOP);
        list.setBorder(titledBorder);

        return list;
    }

    private <T> JList<T> createJList() {
        return createJList(MUSIC_LIST_PANEL_DIMENSION.width,
                MUSIC_LIST_PANEL_DIMENSION.height);
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

    private JPanel createCustomizedPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBorder(createBorder());
        jPanel.setBackground(Color.gray);

        return jPanel;
    }
}
