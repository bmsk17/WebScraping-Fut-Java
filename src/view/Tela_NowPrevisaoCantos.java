/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.ProximoJogoDAO;
import net.sourceforge.htmlunit.corejs.javascript.TopLevel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author Bernardo
 */
public class Tela_NowPrevisaoCantos extends javax.swing.JInternalFrame {
    /**
     * Creates new form TelaCadastroJogo
     */
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
    public Tela_NowPrevisaoCantos() throws IOException {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.  
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPCasa = new javax.swing.JPanel();
        lMedCasaAfavor = new javax.swing.JLabel();
        lMedCasaContra = new javax.swing.JLabel();
        lMedCasaTotal = new javax.swing.JLabel();
        lMedCasaAfavor1 = new javax.swing.JLabel();
        lMedCasaContra1 = new javax.swing.JLabel();
        txtCasaFT = new javax.swing.JLabel();
        CasaContraFT = new javax.swing.JLabel();
        CasaTotalFT = new javax.swing.JLabel();
        CasaAfavorFT = new javax.swing.JLabel();
        jPVisitante = new javax.swing.JPanel();
        lMedCasaContra3 = new javax.swing.JLabel();
        CasaTotalFT1 = new javax.swing.JLabel();
        CasaContraFT1 = new javax.swing.JLabel();
        CasaAfavorFT1 = new javax.swing.JLabel();
        lMedCasaTotal1 = new javax.swing.JLabel();
        txtCasaFT1 = new javax.swing.JLabel();
        lMedCasaAfavor2 = new javax.swing.JLabel();
        lMedCasaContra2 = new javax.swing.JLabel();
        txtQtdJogos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPVisitante1 = new javax.swing.JPanel();
        lMedCasaContra4 = new javax.swing.JLabel();
        CasaTotalFT2 = new javax.swing.JLabel();
        CasaAfavorFT2 = new javax.swing.JLabel();
        lMedCasaTotal2 = new javax.swing.JLabel();
        txtCasaFT2 = new javax.swing.JLabel();
        CasaTotal1T2 = new javax.swing.JLabel();
        lMedCasaAfavor3 = new javax.swing.JLabel();
        CasaTotal2T2 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jPCasa.setBackground(new java.awt.Color(255, 255, 255));
        jPCasa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time Casa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
        jPCasa.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPCasa.setPreferredSize(new java.awt.Dimension(400, 150));

        lMedCasaAfavor.setText("Média Afavor :");

        lMedCasaContra.setText("Média Contra :");

        lMedCasaTotal.setText("Média Total :");

        txtCasaFT.setText("FT");

        javax.swing.GroupLayout jPCasaLayout = new javax.swing.GroupLayout(jPCasa);
        jPCasa.setLayout(jPCasaLayout);
        jPCasaLayout.setHorizontalGroup(
            jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCasaLayout.createSequentialGroup()
                .addGroup(jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCasaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lMedCasaContra1)
                        .addGap(152, 152, 152))
                    .addGroup(jPCasaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lMedCasaContra)
                            .addComponent(lMedCasaTotal)
                            .addComponent(lMedCasaAfavor))
                        .addGap(18, 18, 18)
                        .addGroup(jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCasaLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtCasaFT))
                            .addComponent(CasaAfavorFT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CasaContraFT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CasaTotalFT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lMedCasaAfavor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(140, 140, 140))
        );
        jPCasaLayout.setVerticalGroup(
            jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCasaLayout.createSequentialGroup()
                .addGroup(jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCasaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lMedCasaAfavor1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPCasaLayout.createSequentialGroup()
                        .addComponent(txtCasaFT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lMedCasaAfavor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CasaAfavorFT, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lMedCasaContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CasaContraFT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lMedCasaTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CasaTotalFT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lMedCasaContra1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPVisitante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time Visitante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
        jPVisitante.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPVisitante.setPreferredSize(new java.awt.Dimension(400, 150));

        lMedCasaTotal1.setText("Média Total :");

        txtCasaFT1.setText("FT");

        lMedCasaAfavor2.setText("Média Afavor :");

        lMedCasaContra2.setText("Média Contra :");

        javax.swing.GroupLayout jPVisitanteLayout = new javax.swing.GroupLayout(jPVisitante);
        jPVisitante.setLayout(jPVisitanteLayout);
        jPVisitanteLayout.setHorizontalGroup(
            jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVisitanteLayout.createSequentialGroup()
                .addGroup(jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPVisitanteLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lMedCasaContra3))
                    .addGroup(jPVisitanteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lMedCasaContra2)
                            .addComponent(lMedCasaTotal1)
                            .addComponent(lMedCasaAfavor2))
                        .addGap(18, 18, 18)
                        .addGroup(jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPVisitanteLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtCasaFT1))
                            .addComponent(CasaAfavorFT1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CasaContraFT1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CasaTotalFT1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPVisitanteLayout.setVerticalGroup(
            jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVisitanteLayout.createSequentialGroup()
                .addComponent(txtCasaFT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lMedCasaAfavor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CasaAfavorFT1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lMedCasaContra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CasaContraFT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lMedCasaTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CasaTotalFT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMedCasaContra3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtQtdJogos.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txtQtdJogos.setForeground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Quantidade de Jogos :");

        jPVisitante1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Predição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
        jPVisitante1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPVisitante1.setPreferredSize(new java.awt.Dimension(400, 150));

        lMedCasaTotal2.setText("Média Total :");

        txtCasaFT2.setText("FT");

        lMedCasaAfavor3.setText("Cantos :");

        javax.swing.GroupLayout jPVisitante1Layout = new javax.swing.GroupLayout(jPVisitante1);
        jPVisitante1.setLayout(jPVisitante1Layout);
        jPVisitante1Layout.setHorizontalGroup(
            jPVisitante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVisitante1Layout.createSequentialGroup()
                .addGroup(jPVisitante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPVisitante1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lMedCasaContra4))
                    .addGroup(jPVisitante1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPVisitante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPVisitante1Layout.createSequentialGroup()
                                .addComponent(lMedCasaTotal2)
                                .addGap(36, 36, 36)
                                .addComponent(CasaTotal1T2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CasaTotal2T2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CasaTotalFT2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPVisitante1Layout.createSequentialGroup()
                                .addComponent(lMedCasaAfavor3)
                                .addGap(18, 18, 18)
                                .addGroup(jPVisitante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPVisitante1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtCasaFT2))
                                    .addComponent(CasaAfavorFT2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPVisitante1Layout.setVerticalGroup(
            jPVisitante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVisitante1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCasaFT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPVisitante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CasaAfavorFT2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lMedCasaAfavor3))
                .addGap(50, 50, 50)
                .addGroup(jPVisitante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lMedCasaTotal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CasaTotal1T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CasaTotal2T2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CasaTotalFT2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMedCasaContra4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(txtQtdJogos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPVisitante1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(jPVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jLabel2)
                    .addContainerGap(340, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtQtdJogos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jPVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jPVisitante1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void readJTable() throws IOException{
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage(this.getLink());
        String Source = currentPage.asXml();
        
        Document doo =Jsoup.parse(Source);
        
        Elements nomeA = doo.select("[class=sclassName]");
        ArrayList<String> noo = new ArrayList<>();
        for(Element item:nomeA){
            noo.add(item.text());
        }
        jPCasa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, noo.get(0), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
        jPVisitante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, noo.get(1), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N
         
        
        //Tabela 11
        Elements tabela = doo.select("[id=table_v1]");
        Elements items = tabela.select("tr:gt(2)").select("[id*=tr]");  
        
        Double mCasaFeitos=0.0;
        Double mCasaSofridos=0.0;
        int cont=0;
        for(Element it: items){
            String data = it.select("td:eq(1)").text();
            String timeA = it.select("td:eq(2)").select("a").text();
            String timeB = it.select("td:eq(6)").select("a").text();
            String cantos = it.select("td:eq(5)").text();           
            int traco=0;
            for(int i=0;i<cantos.length();i++){
                if(cantos.substring(i,i+1).equals("-")){ 
                    traco=i;
                }
            }
            Double nCantosCasa = Double.parseDouble(cantos.substring(0,traco));
            Double nCantosVisitante = Double.parseDouble(cantos.substring(traco+1,cantos.length()));
            cont++;
            
            mCasaFeitos=mCasaFeitos+nCantosCasa;
            mCasaSofridos=mCasaSofridos+nCantosVisitante;
            
            
        }
                   
        mCasaFeitos=mCasaFeitos/cont;
        mCasaSofridos=mCasaSofridos/cont;
        
        CasaAfavorFT.setText(mCasaFeitos.toString());
        CasaContraFT.setText(mCasaSofridos.toString());
        CasaTotalFT.setText(String.valueOf(mCasaSofridos+mCasaFeitos));
        txtQtdJogos.setText(Integer.toString(cont));
        
        
        //Tabela 11
        Elements tabela2 = doo.select("[id=table_v2]");
        Elements items2 = tabela2.select("tr:gt(2)").select("[id*=tr]");  
        
        Double mCasaFeitos2=0.0;
        Double mCasaSofridos2=0.0;
        int cont2=0;
        for(Element it: items2){
            String data = it.select("td:eq(1)").text();
            String timeA = it.select("td:eq(2)").select("a").text();
            String timeB = it.select("td:eq(6)").select("a").text();
            String cantos = it.select("td:eq(5)").text();           
            int traco=0;
            for(int i=0;i<cantos.length();i++){
                if(cantos.substring(i,i+1).equals("-")){ 
                    traco=i;
                }
            }
            Double nCantosCasa2 = Double.parseDouble(cantos.substring(0,traco));
            Double nCantosVisitante2 = Double.parseDouble(cantos.substring(traco+1,cantos.length()));
            cont2++;
            
            mCasaFeitos2=mCasaFeitos2+nCantosCasa2;
            mCasaSofridos2=mCasaSofridos2+nCantosVisitante2;
            
        }        
        mCasaFeitos2=mCasaFeitos2/cont2;
        mCasaSofridos2=mCasaSofridos2/cont2;
        
        CasaAfavorFT1.setText(mCasaFeitos2.toString());
        CasaContraFT1.setText(mCasaSofridos2.toString());
        CasaTotalFT1.setText(String.valueOf(mCasaFeitos2+mCasaSofridos2));
        
        
        CasaAfavorFT2.setText(String.valueOf((mCasaFeitos2+mCasaSofridos2+mCasaSofridos+mCasaFeitos)/2));
        
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CasaAfavorFT;
    private javax.swing.JLabel CasaAfavorFT1;
    private javax.swing.JLabel CasaAfavorFT2;
    private javax.swing.JLabel CasaContraFT;
    private javax.swing.JLabel CasaContraFT1;
    private javax.swing.JLabel CasaTotal1T2;
    private javax.swing.JLabel CasaTotal2T2;
    private javax.swing.JLabel CasaTotalFT;
    private javax.swing.JLabel CasaTotalFT1;
    private javax.swing.JLabel CasaTotalFT2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPCasa;
    private javax.swing.JPanel jPVisitante;
    private javax.swing.JPanel jPVisitante1;
    private javax.swing.JLabel lMedCasaAfavor;
    private javax.swing.JLabel lMedCasaAfavor1;
    private javax.swing.JLabel lMedCasaAfavor2;
    private javax.swing.JLabel lMedCasaAfavor3;
    private javax.swing.JLabel lMedCasaContra;
    private javax.swing.JLabel lMedCasaContra1;
    private javax.swing.JLabel lMedCasaContra2;
    private javax.swing.JLabel lMedCasaContra3;
    private javax.swing.JLabel lMedCasaContra4;
    private javax.swing.JLabel lMedCasaTotal;
    private javax.swing.JLabel lMedCasaTotal1;
    private javax.swing.JLabel lMedCasaTotal2;
    private javax.swing.JLabel txtCasaFT;
    private javax.swing.JLabel txtCasaFT1;
    private javax.swing.JLabel txtCasaFT2;
    private javax.swing.JLabel txtQtdJogos;
    // End of variables declaration//GEN-END:variables
}
