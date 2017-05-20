package com.music.web.bean;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20.
 */
public class UserBasedRecommendate {

    private static  final  String file = "G:/project/music-web/app/src/data/pre.data";

    private final static int NEIGHBORHOOD_NUM = 2; //获取邻居用户的数量

    private final static int RECOMMENDER_NUM = 5;//推荐物品的数量

    public static List<RecommendedItem> getRecommendateItemsByUid(Long id) throws  Exception{
        //建立数据模型
        DataModel model = new FileDataModel(new File(file));
        //获取用户的相似度
        UserSimilarity user = new EuclideanDistanceSimilarity(model);
        //获取用户的相似邻居
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);
        //获取用列表
        LongPrimitiveIterator iter = model.getUserIDs();

        List<RecommendedItem> list = new ArrayList<RecommendedItem>();
        while (iter.hasNext()) {
            long uid = iter.nextLong();
            if(uid == id){
                //获取该用户固定数量的推荐物品
                list = r.recommend(uid, RECOMMENDER_NUM);
            }
        }

        return  list;
    }

}
