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

import ptithcm.entity.Staff;

public class StaffPDFView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseFont bf = BaseFont.createFont("C:\\windows\\fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bf, 13);
		Font fontTitle = new Font(bf, 15);

      Paragraph p = new Paragraph("DANH SÁCH NHÂN VIÊN", fontTitle);
      p.setAlignment(Element.ALIGN_CENTER);
      p.setSpacingAfter(20);
      PdfPTable table;
      table = new PdfPTable(new float[]{10,4,3,5,5,10});//Thiết lập tỉ lệ giữa các cột trong bảng
      table.setWidthPercentage(100);//Thiết lập chiều rộng
      table.addCell(PDF.getCell("Họ tên", fontTitle));
      table.addCell(PDF.getCell("Ngày sinh", fontTitle));
      table.addCell(PDF.getCell("Giới tính", fontTitle));
      table.addCell(PDF.getCell("Số điện thoại", fontTitle));
      table.addCell(PDF.getCell("Email", fontTitle));
      table.addCell(PDF.getCell("Địa chỉ", fontTitle));
		
		ArrayList<Staff> staffs = (ArrayList<Staff>) model.get("staffs");

		for (Staff s : staffs) {
			table.addCell(PDF.getCell(s.getNameStaff(), font));
			table.addCell(PDF.getCell(s.getBirthdayStaff().toString(), font));
			table.addCell(PDF.getCell(s.getSexStaff(), font));
			table.addCell(PDF.getCell(s.getPhoneStaff(), font));
			table.addCell(PDF.getCell(s.getEmailStaff(), font));
			table.addCell(PDF.getCell(s.getAddressStaff(), font));
		}
		document.add(p);
		document.add(table);
	}
	
}