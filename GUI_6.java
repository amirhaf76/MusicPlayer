import javax.swing.*;

public class GUI_6 extends javax.swing.JFrame {

    public GUI_6() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        invalid = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon img = new ImageIcon("global.png");
        setIconImage(img.getImage());
        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add.setForeground(new java.awt.Color(0, 204, 51));
        add.setText("add");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("IP :");

        invalid.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(host))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(add)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(invalid, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(add)
                                        .addComponent(invalid))
                                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        setResizable(false);
        setLocation(700,300);
        setVisible(true);
        pack();
    }

    private void addMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private javax.swing.JButton add;
    private javax.swing.JTextField host;
    private javax.swing.JLabel invalid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}





