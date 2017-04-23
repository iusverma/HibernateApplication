package home.practice;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import home.practice.hb1.Stock;
import home.practice.hb1.StockDetail;

public class App {
	public static void main(String[] args) {
		String stockCount = "5";
		System.out.println("Hibernate one to one (XML mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode(stockCount);
		stock.setStockName("PYPL"+stockCount);

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PayPal"+stockCount);
		stockDetail.setCompDesc("Best Online Payments Company");
		stockDetail.setRemark("Safe and secure payemnts");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
		
		Query query = session.createQuery("from Stock where stockCode = :code ");
		query.setParameter("code", "4717");
		List list = query.list();
		
		for(Object obj: list){
			Stock st = (Stock)obj;
			System.out.print(st.getStockCode() +", ");
			System.out.print(st.getStockName() +", ");
			System.out.print(st.getStockDetail() +", ");
			System.out.println(st.getStockId());
		}
	}
}
