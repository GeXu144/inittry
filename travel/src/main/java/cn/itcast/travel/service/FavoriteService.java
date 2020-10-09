package cn.itcast.travel.service;

public interface FavoriteService {
    /**
     * 是否收藏
     * @param uid
     * @param rid
     * @return
     */
    public boolean isFavorite(String rid,int uid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
     public void add(String rid, int uid);
}
