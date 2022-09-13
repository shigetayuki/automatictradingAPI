package jp.mydns.automatictrading.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.mydns.automatictrading.dao.FkDao;
import jp.mydns.automatictrading.dao.FootkeyDao;
import jp.mydns.automatictrading.dao.FsDao;
import jp.mydns.automatictrading.dao.MxDao;
import jp.mydns.automatictrading.dao.RefkDao;
import jp.mydns.automatictrading.entity.Fk;
import jp.mydns.automatictrading.entity.Footkey;
import jp.mydns.automatictrading.entity.Fs;
import jp.mydns.automatictrading.entity.Mx;
import jp.mydns.automatictrading.entity.Refk;
import jp.mydns.automatictrading.entity.TradeSystem;

@Service
public class BatchService {
    @Autowired
	private FootkeyDao footkeyDao;
    @Autowired
	private FkDao fkDao;
    @Autowired
    private FsDao fsDao;
    @Autowired
    private RefkDao refkDao;
    @Autowired
    private MxDao mxDao;

    public void insertTradeSystem(List<TradeSystem> tradSystemList){
        List<Footkey> footkey = getFootkey(tradSystemList);
        List<Fk> fk = getFk(tradSystemList);
        List<Fs> fs = getFs(tradSystemList);
        List<Refk> refk = getRefk(tradSystemList);
        List<Mx> mx = getMx(tradSystemList);

        footkeyDao.saveAll(footkey);
        fkDao.saveAll(fk);
        fsDao.saveAll(fs);
        refkDao.saveAll(refk);
        mxDao.saveAll(mx);
    }

    private List<Footkey> getFootkey(List<TradeSystem> tradSystemList){
        List<Footkey> footkeyList = new ArrayList<>();
        
        for(TradeSystem ts:tradSystemList){
            Footkey footkey = new Footkey();
            footkey.setFkId(ts.getFkId());
            footkey.setFkDate(ts.getFkDate());
            footkey.setFkTime(ts.getFkTime());
            footkey.setPrice(ts.getPrice());
            footkey.setTrend(ts.getTrend());
            footkey.setMountain(ts.getMountain());
            footkey.setValley(ts.getValley());
            footkey.setSendFlg(ts.getSendFlg());
            footkeyList.add(footkey);
        }
        return footkeyList;
    }
    private List<Fk> getFk(List<TradeSystem> tradSystemList){
        List<Fk> fkList = new ArrayList<>();
        
        for(TradeSystem ts:tradSystemList){
            Fk fk = new Fk();
            fk.setFkId(ts.getFkId());
            fk.setSign(ts.getFkSign());
            fk.setInterest(ts.getFkInterest());
            fk.setPrevOrderLocation(ts.getFkPrevOrderLocation());
            fkList.add(fk);
        }
        return fkList;
    }
    private List<Fs> getFs(List<TradeSystem> tradSystemList){
        List<Fs> FsList = new ArrayList<>();
        
        for(TradeSystem ts:tradSystemList){
            Fs Fs = new Fs();
            Fs.setFkId(ts.getFkId());
            Fs.setSign(ts.getFsSign());
            Fs.setInterest(ts.getFsInterest());
            Fs.setPrevOrderLocation(ts.getFsPrevOrderLocation());
            FsList.add(Fs);
        }
        return FsList;
    }
    private List<Refk> getRefk(List<TradeSystem> tradSystemList){
        List<Refk> RefkList = new ArrayList<>();
        
        for(TradeSystem ts:tradSystemList){
            Refk Refk = new Refk();
            Refk.setFkId(ts.getFkId());
            Refk.setSign(ts.getRefkSign());
            Refk.setInterest(ts.getRefkInterest());
            Refk.setPrevOrderLocation(ts.getRefkPrevOrderLocation());
            RefkList.add(Refk);
        }
        return RefkList;
    }
    private List<Mx> getMx(List<TradeSystem> tradSystemList){
        List<Mx> MxList = new ArrayList<>();
        
        for(TradeSystem ts:tradSystemList){
            Mx Mx = new Mx();
            Mx.setFkId(ts.getFkId());
            Mx.setSign(ts.getMxSign());
            Mx.setInterest(ts.getMxInterest());
            Mx.setPrevOrderLocation(ts.getMxPrevOrderLocation());
            MxList.add(Mx);
        }
        return MxList;
    }
}
