package com.tudublin.apms.service;

import com.tudublin.apms.entity.Details;
import com.tudublin.apms.entity.SpecialList;
import com.tudublin.apms.mapper.DetailsMapper;

public class DetailsService {
    DetailsMapper detailsMapper = new DetailsMapper();
    public Details selectById(Long detailsId){return detailsMapper.selectDetailsById(detailsId);}

    public Object insertUserDetails(Details details){
        return detailsMapper.insertUserDetails(details);
    }
}
