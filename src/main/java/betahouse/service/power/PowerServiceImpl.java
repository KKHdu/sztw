package betahouse.service.power;

import betahouse.mapper.PowerMapper;
import betahouse.model.Power;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by x1654 on 2017/7/11.
 */
@Service
public class PowerServiceImpl implements PowerService{

    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<Integer> getPowerByUserId(int userId) {
        Power powerDTO =powerMapper.selectByUserId(userId);
        return JSON.parseArray(powerDTO.getPower(), Integer.class);
    }

    @Override
    public int updatePowerByUserId(int userId, int power) {
        Power powerDTO = powerMapper.selectByUserId(userId);
        List<Integer> listDTO = JSON.parseArray(powerDTO.getPower(), Integer.class);
        listDTO.add(power);
        listDTO = new ArrayList<Integer>(new HashSet<Integer>(listDTO));
        powerDTO.setPower(listDTO.toString());
        return powerMapper.updateByUserId(powerDTO);
    }
}
