package ptithcm.pdf;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ptithcm.entity.Bill;
import ptithcm.entity.DetailBill;

@Transactional
public class BillUnconfirmPDFView extends AbstractPdfView {
	@Autowired SessionFactory factory;
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseFont bf = BaseFont.createFont("C:\\windows\\fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bf, 13);
		Font fontTitle = new Font(bf, 15);

      Paragraph p = new Paragraph("DANH SÁCH ĐƠN HÀNG CHƯA XÁC NHẬN", fontTitle);
      p.setAlignment(Element.ALIGN_CENTER);
      p.setSpacingAfter(20);
      PdfPTable table;
      table = new PdfPTable(new float[]{2,2,2,2});//Thiết lập tỉ lệ giữa các cột trong bảng
      table.setWidthPercentage(110);//Thiết lập chiều rộng
      table.addCell(PDF.getCell("Mã hóa đơn", fontTitle));
      table.addCell(PDF.getCell("Mã khách hàng", fontTitle));
      table.addCell(PDF.getCell("Ngày lập", fontTitle));
      table.addCell(PDF.getCell("Giá tiền", fontTitle));
      
		
		ArrayList<Bill> bills = (ArrayList<Bill>) model.get("bills");

		for (Bill s : bills) {
			table.addCell(PDF.getCell(s.getIdBill().toString(), font));
			table.addCell(PDF.getCell(s.getCustomer().getIdCustomer(), font));
			table.addCell(PDF.getCell(s.getDateBill().toString(), font));			
			table.addCell(PDF.getCell(s.getCostBill().toString(), font));			
		}
		document.add(p);
		document.add(table);
	}
}
