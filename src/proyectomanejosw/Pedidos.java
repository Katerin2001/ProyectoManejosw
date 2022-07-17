/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomanejosw;

import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author byron
 */
public class Pedidos extends javax.swing.JFrame {

    /**
     * Creates new form Pedidos
     */
    DefaultComboBoxModel modelosCB;
    DefaultComboBoxModel productosCB;
    DefaultComboBoxModel tallasp;
    SpinnerNumberModel modeloSpinner;
    DefaultListModel modeloLista;
    LinkedList<Producto> productos;
    int restaAmarillo = 0;
    int restaAzul = 0;
    int restaRojo = 0;
    int estado = 0;

    public Pedidos() {
        initComponents();
        modelosCB = new DefaultComboBoxModel();
        productosCB = new DefaultComboBoxModel();
        tallasp = new DefaultComboBoxModel();
        modeloSpinner = new SpinnerNumberModel();
        modeloLista = new DefaultListModel();
        productos = new LinkedList<>();
        limiteSpiner();
        agregarListaProductos();
        cargarListaCostos();
        cargarCombobox();
        selecionBloqueada();
        bloquearTamaños();
        desbloquearAceptarProductos();
    }

    public void limiteSpiner() {

        modeloSpinner.setMaximum(100);
        modeloSpinner.setMinimum(0);
        jspnCantidad.setModel(modeloSpinner);

    }

    public void cargarListaCostos() {

        for (int i = 0; i < productos.size(); i++) {
            modeloLista.addElement(productos.get(i).getNombre());
            modeloLista.addElement("Talla S : " + productos.get(i).getCostoS() + " $");
            modeloLista.addElement("Talla M : " + productos.get(i).getCostoM() + "$");
            modeloLista.addElement("Talla L : " + productos.get(i).getCostoL() + "$");

        }

        jlstCostos.setModel(modeloLista);
    }

    void agregarListaProductos() {
        productos.add(new Producto("Camiseta", 5, 8, 10));
        productos.add(new Producto("Camisa", 10, 12, 15));
        productos.add(new Producto("Chaqueta", 8, 12, 15));
        productos.add(new Producto("Pantalon", 7, 12, 15));
    }

    boolean desbloquearAceptarProductos() {
        if (Integer.valueOf(jspnCantidad.getValue().toString()) > 0) {
            jbtnAceptar.setEnabled(true);
            return true;
        }
        jbtnAceptar.setEnabled(false);
        return false;

    }

    boolean bloquearTamaños() {

        jcbxTallas.setEnabled(false);
        jtxtCantidad.setEnabled(false);
        jcbxColor.setEnabled(false);
        jbtnGuardar.setEnabled(false);
        jbtnEditar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        return true;

    }

    public void cargarCombobox() {
        String[] modelo = {"Amarillo", "Azul", "Rojo"};
        for (String i : modelo) {
            modelosCB.addElement(i);
        }

        jcbxColor.setModel(modelosCB);
        String[] producto = {"Camiseta", "Camisa", "Chaqueta", "Pantalon"};
        for (String i : producto) {
            productosCB.addElement(i);

        }
        jcbxProductos.setModel(productosCB);
        String[] tallas = {"S", "M", "L"};
        for (String i : tallas) {
            tallasp.addElement(i);
        }
        jcbxTallas.setModel(tallasp);

    }

    public boolean validarProductos(boolean logico) {
        int cantAmarillo = 0;
        int cantAzul = 0;
        int cantRojo = 0;
        int suma;
        int valorSpiner = Integer.valueOf(jspnCantidad.getValue().toString());
        System.out.println(valorSpiner);
        try {
            if (jchbAmarillo.isSelected()) {
                cantAmarillo = Integer.valueOf(jtxtAmarillo.getText());
                restaAmarillo = cantAmarillo;
//                setRestaAmarillo(restaAmarillo);

            }
            if (jchbAzul.isSelected()) {
                cantAzul = Integer.valueOf(jtxtAzul.getText());
                restaAzul = cantAzul;
            }
            if (jchbRojo.isSelected()) {
                cantRojo = Integer.valueOf(jtxtRojo.getText());
                restaRojo = cantRojo;

            }

            suma = cantAmarillo + cantAzul + cantRojo;

            if (valorSpiner != suma) {
                JOptionPane.showMessageDialog(this, "La suma de colores no coincide con la cantidad del producto");
                return false;
            }
//            limpiarBloquearPedidos();
            JOptionPane.showMessageDialog(this, "Validación correcta");
            desbloquearTamaños();
            return true;
        } catch (Exception e) {
        }
        return true;
        //if(Integer.valueOf(jspnCantidad.getValue().toString())){
        //} else {
    }

    public void selecionBloqueada() {

        try {

            if (jchbAmarillo.isSelected()) {
                jtxtAmarillo.setEnabled(true);
            } else {
                jtxtAmarillo.setEnabled(false);
            }
            if (jchbAzul.isSelected()) {
                jtxtAzul.setEnabled(true);
            } else {
                jtxtAzul.setEnabled(false);
            }
            if (jchbRojo.isSelected()) {
                jtxtRojo.setEnabled(true);

            } else {
                jtxtRojo.setEnabled(false);
            }
        } catch (Exception e) {

        }
    }

    boolean desbloquearTamaños() {
        System.out.println("Dentro del metodo de desbloquear tamaño");
        jcbxTallas.setEnabled(true);
        jtxtCantidad.setEnabled(true);
        jcbxColor.setEnabled(true);
        jbtnGuardar.setEnabled(true);

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbxProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jspnCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jchbAmarillo = new javax.swing.JCheckBox();
        jchbAzul = new javax.swing.JCheckBox();
        jchbRojo = new javax.swing.JCheckBox();
        jtxtAmarillo = new javax.swing.JTextField();
        jtxtAzul = new javax.swing.JTextField();
        jtxtRojo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jbtnAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcbxTallas = new javax.swing.JComboBox<>();
        jtxtCantidad = new javax.swing.JTextField();
        jcbxColor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlstCostos = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pedidos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Productos");

        jcbxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Cantidad");

        jspnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspnCantidadStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Colores:");

        jchbAmarillo.setText("Amarillo");
        jchbAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchbAmarilloActionPerformed(evt);
            }
        });

        jchbAzul.setText("Azul");
        jchbAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchbAzulActionPerformed(evt);
            }
        });

        jchbRojo.setText("Rojo");
        jchbRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchbRojoActionPerformed(evt);
            }
        });

        jbtnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAceptar.setIcon(new javax.swing.ImageIcon("D:\\Programacion\\Programacion3\\ProyectoManejosw\\src\\image\\comprobado.png")); // NOI18N
        jbtnAceptar.setText("Validar");
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jspnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jtxtAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jchbAmarillo)
                                                    .addComponent(jchbAzul)
                                                    .addComponent(jchbRojo))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addComponent(jtxtAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jtxtRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbtnAceptar))))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jspnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchbAmarillo)
                    .addComponent(jtxtAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchbAzul)
                    .addComponent(jtxtAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchbRojo)
                    .addComponent(jtxtRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tamaños");

        jcbxTallas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtxtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCantidadActionPerformed(evt);
            }
        });

        jcbxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Tallas");

        jLabel7.setText("Cantidad");

        jLabel8.setText("Color");

        jbtnGuardar.setIcon(new javax.swing.ImageIcon("D:\\Programacion\\Programacion3\\ProyectoManejosw\\src\\image\\application_double.png")); // NOI18N
        jbtnGuardar.setText("Guardar");

        jbtnEditar.setIcon(new javax.swing.ImageIcon("D:\\Programacion\\Programacion3\\ProyectoManejosw\\src\\image\\application_edit (1).png")); // NOI18N
        jbtnEditar.setText("Editar");

        jbtnEliminar.setIcon(new javax.swing.ImageIcon("D:\\Programacion\\Programacion3\\ProyectoManejosw\\src\\image\\application_delete.png")); // NOI18N
        jbtnEliminar.setText("Eliminar");

        jlstCostos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlstCostos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbxTallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jcbxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel8))))
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbtnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addGap(12, 12, 12))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbxTallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnGuardar)
                            .addComponent(jbtnEditar)
                            .addComponent(jbtnEliminar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Línea de pedido");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCantidadActionPerformed

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        // TODO add your handling code here:
        validarProductos(true);
    }//GEN-LAST:event_jbtnAceptarActionPerformed

    private void jspnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspnCantidadStateChanged
        // TODO add your handling code here:
        desbloquearAceptarProductos();
    }//GEN-LAST:event_jspnCantidadStateChanged

    private void jchbAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchbAmarilloActionPerformed
        // TODO add your handling code here:

        selecionBloqueada();
    }//GEN-LAST:event_jchbAmarilloActionPerformed

    private void jchbAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchbAzulActionPerformed
        // TODO add your handling code here:

        selecionBloqueada();
    }//GEN-LAST:event_jchbAzulActionPerformed

    private void jchbRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchbRojoActionPerformed
        // TODO add your handling code here:

        selecionBloqueada();
    }//GEN-LAST:event_jchbRojoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnAceptar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JComboBox<String> jcbxColor;
    private javax.swing.JComboBox<String> jcbxProductos;
    private javax.swing.JComboBox<String> jcbxTallas;
    private javax.swing.JCheckBox jchbAmarillo;
    private javax.swing.JCheckBox jchbAzul;
    private javax.swing.JCheckBox jchbRojo;
    private javax.swing.JList<String> jlstCostos;
    private javax.swing.JSpinner jspnCantidad;
    private javax.swing.JTextField jtxtAmarillo;
    private javax.swing.JTextField jtxtAzul;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtRojo;
    // End of variables declaration//GEN-END:variables
}
