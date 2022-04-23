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
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ptithcm.entity.Bill;
import ptithcm.entity.DetailBill;

public class BillDetailPDFView extends AbstractPdfView {
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseFont bf = BaseFont.createFont("C:\\windows\\fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bf, 13);
		Font fontTitle = new Font(bf, 15);
		
      Paragraph p = new Paragraph("DANH SÁCH CHI TIẾT ĐƠN HÀNG", fontTitle);
      p.setAlignment(Element.ALIGN_CENTER);
      p.setSpacingAfter(20);
      Paragraph p1= new Paragraph("Khách hàng:" , fontTitle);
      p1.setAlignment(Element.ALIGN_LEFT);
      p1.setSpacingAfter(20);
      Paragraph p2= new Paragraph("Ngày lập:" , fontTitle);
      p2.setAlignment(Element.ALIGN_LEFT);
      p2.setSpacingAfter(20);
      Paragraph p3= new Paragraph("Số tiền:" , fontTitle);
      p3.setAlignment(Element.ALIGN_LEFT);
      p3.setSpacingAfter(20);
      PdfPTable table;
      table = new PdfPTable(new float[]{2,2,2,2,2});//Thiết lập tỉ lệ giữa các cột trong bảng
      table.setWidthPercentage(110);//Thiết lập chiều rộng
      table.addCell(PDF.getCell("Số seri", fontTitle));
      table.addCell(PDF.getCell("Tên sản phẩm", fontTitle));
      table.addCell(PDF.getCell("Màu sắc", fontTitle));
      table.addCell(PDF.getCell("Số lượng", fontTitle));
      table.addCell(PDF.getCell("Đơn giá", fontTitle));
      
		
		ArrayList<DetailBill> detailBills = (ArrayList<DetailBill>) model.get("detailBills");

		for (DetailBill s : detailBills) {
			table.addCell(PDF.getCell(s.getPk().getPhone().getIdPhone().toString(), font));
			table.addCell(PDF.getCell(s.getPk().getPhone().getNamePhone(), font));
			table.addCell(PDF.getCell(s.getColorDetailBill(), font));
			table.addCell(PDF.getCell(String.valueOf(s.getAmount()), font));
			table.addCell(PDF.getCell(String.valueOf(s.getPk().getPhone().getCostPhone()), font));
			
		}
		document.add(p);
		document.add(table);
	}
}
