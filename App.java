
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.property.BorderRadius;
import com.itextpdf.layout.property.UnitValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.event.CellEditorListener;

public class App {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Create a new PDF document
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("/Users/apple/Desktop/id_card.pdf"));

        // Create a document object
        Document document = new Document(pdfDoc);

        Table brown = new Table(new float[]{300,100});
        brown.setWidth(550);
        brown.setHeight(700);
        brown.setBorder(new SolidBorder(ColorConstants.BLACK, 10));
        
        for(int i=1;i<=4;i++){
              if(i==1){
                Cell r1= new Cell();
                Paragraph paragraph = new Paragraph();
                paragraph.add(new Text("This is the first line of text."));
                paragraph.add(new Text("\n")); // Add a line break
                paragraph.add(new Text("This is the second line of text."));
                r1.add(paragraph);
                r1.setHeight(25);
                r1.setWidth(100);
                brown.addCell(r1);

                Cell r2 = new Cell();
                Image photo = new Image(ImageDataFactory.create("/Users/apple/Desktop/kccitmProject/spring-social/src/main/java/kccImage.png"));
                photo.scaleToFit(50, 25);
                r2.add(photo);
                brown.addCell(r2);
              }
                
              else if(i==2){
                Cell r3 = new Cell();
                Image photo2 = new Image(ImageDataFactory.create("/Users/apple/Desktop/kccitmProject/spring-social/src/main/java/kccImage.png"));
                photo2.scaleToFit(100, 200);
                r3.add(photo2);
                brown.addCell(r3);
              }

              else if(i==3){
                Cell r4= new Cell();
                Text data4= new Text("PLUS here");
                data4.setFont(PdfFontFactory.createFont("Helvetica", true));
                data4.setFontSize(20);
                r4.add(new Paragraph(data4));
                r4.setHeight(25);
                r4.setWidth(10);
                brown.addCell(r4);

             }

             else{
                Cell r5= new Cell();
                Text data5= new Text("KCC  here ITM");
                data5.setFont(PdfFontFactory.createFont("Helvetica", true));
                data5.setFontSize(10);
                r5.add(new Paragraph(data5));
                r5.setHeight(25);
                r5.setWidth(100);
                brown.addCell(r5);
             }
        }
           

        // Add the brown table to the document
        document.add(brown);
        document.close();
        pdfDoc.close();
    }
} 