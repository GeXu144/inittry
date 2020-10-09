package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {
    /**
     * 根据rid跟uid查询Favorite收藏
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid,int uid);

    /**
     * 根据rid查询记录
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    public void add(int i, int uid);
}
