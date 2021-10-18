package dao;

import java.util.List;

import model.Article;

public interface IDAOArticle extends IDAO<Article,Integer> {

	public List<Article> findByRestaurantId(int idResto);
}
