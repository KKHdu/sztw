package betahouse.service.financial;

import betahouse.model.ClubFinancialFlow;
import betahouse.model.VO.ClubFinance;

import java.util.List;
import java.util.Map;

/**
 * Created by x1654 on 2017/7/14.
 */
public interface ClubFinancialFlowService {

    List<ClubFinancialFlow> listAll();

    List<ClubFinance> listClubFinancialFlowByClubId(int clubId);

    Map<String, int[]> listAllClubFinance();

    ClubFinancialFlow getClubFinancialFlowByFormId(int formId);

    int insert(int clubId, int formId, int applySelfMoney, int applyReserveMoney,  int income, String comment);

    int insert(int clubId, String comment, int handler, int change, int money);

}
