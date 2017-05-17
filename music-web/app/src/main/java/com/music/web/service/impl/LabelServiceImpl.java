package com.music.web.service.impl;

import com.music.web.dao.LabelDao;
import com.music.web.entity.Label;
import com.music.web.service.LabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "LabelService")
public class LabelServiceImpl implements LabelService {

    private static  final Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);

    @Autowired
    private LabelDao labelDao;


    public boolean insertLabel(Label label) {
        int result = 0;
        try{
            result = labelDao.insertSelective(label);
        }catch (Exception e){
            logger.info("[LabelServiceImpl][insertLabel]label:"+label.toString()+e);
        }
        return result>0;
    }

    public boolean deletLabelById(int id) {
        int result = 0;
        try{
            result = labelDao.deleteByPrimaryKey(id);
        }catch (Exception e){
            logger.info("[LabelServiceImpl][deletLabelById]id:"+id+e);
        }
        return result>0;
    }

    public Label selectLabel(String filter, int type) {
        Label result = null;
        try{
            result = labelDao.selectLabelByType(filter,type);
        }catch (Exception e){
            logger.info("[LabelServiceImpl][selectLabel] filter:"+filter+e);
        }
        return result;
    }

    public List<Label> selectLabels() {
        List<Label> result = null;
        try{
            result = labelDao.selectLabels();
        }catch (Exception e){
            logger.info("[LabelServiceImpl][selectLabels] filter:"+e);
        }
        return result;
    }
}
