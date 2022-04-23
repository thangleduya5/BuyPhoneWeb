package ptithcm.pdf;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import ptithcm.entity.Phone;


public class PhonePDFView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseFont bf = BaseFont.createFont("C:\\windows\\fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bf, 13);
		Font fontTitle = new Font(bf, 15);

      Paragraph p = new Paragraph("DANH SÁCH ĐIỆN THOẠI", fontTitle);
      p.setAlignment(Element.ALIGN_CENTER);
      p.setSpacingAfter(20);
      PdfPTable table;
      table = new PdfPTable(new float[]{2,2,2,2,2,4,2,2,5});//Thiết lập tỉ lệ giữa các cột trong bảng
      table.setWidthPercentage(110);//Thiết lập chiều rộng
      table.addCell(PDF.getCell("Số Seri", fontTitle));
      table.addCell(PDF.getCell("Tên", fontTitle));
      table.addCell(PDF.getCell("Giá tiền", fontTitle));
      table.addCell(PDF.getCell("Nhãn hiệu", fontTitle));
      table.addCell(PDF.getCell("Năm SX", fontTitle));
      table.addCell(PDF.getCell("CPU", fontTitle));
      table.addCell(PDF.getCell("RAM", fontTitle));
      table.addCell(PDF.getCell("ROM", fontTitle));
      table.addCell(PDF.getCell("Màn hình", fontTitle));
		
		ArrayList<Phone> phones = (ArrayList<Phone>) model.get("phones");

		for (Phone s : phones) {
			table.addCell(PDF.getCell(s.getIdPhone(), font));
			table.addCell(PDF.getCell(s.getNamePhone(), font));
			table.addCell(PDF.getCell(s.getCostPhone().toString(), font));
			table.addCell(PDF.getCell(s.getBrand().getNameBrand(), font));
			table.addCell(PDF.getCell(s.getYearPhone().toString(), font));
			table.addCell(PDF.getCell(s.getCpu().getNameCPU()+"_"+s.getCpu().getSpeedCPU(), font));
			table.addCell(PDF.getCell(s.getRamPhone().toString(), font));
			table.addCell(PDF.getCell(s.getRomPhone().toString(), font));
			table.addCell(PDF.getCell(s.getScreen().getSizeScreen()+"_"+s.getScreen().getTechScreen().getNameTechScreen()+"_"+s.getScreen().getResolution().getNameResolution(), font));
		}
		document.add(p);
		document.add(table);
	}
	
}
