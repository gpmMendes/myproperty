package web.base;

import web.helper.Constants;

import javax.faces.event.PhaseEvent;
import java.io.Serializable;

/**
 * Created by guilherme on 30/12/15.
 */
public abstract class BaseBean implements Serializable {

    private static final long serialVersionUID = -2621340511302440586L;

    public static final String cardMaintMgr = "cardMaintMgr";
    public static final String contactListManagerKey = "contactListMgr";
    public static final String contactManagerKey = "contactMgr";
    public static final String costCenterListManagerKey = "costCentreListMgr";
    public static final String costCenterManagerKey = "costCentreMgr";
    public static final String customerMgr = "custMgr";
    public static final String locationMgr = "locationMgr";
    public static final String merchantMgr = "merchantMgr";
    public static final String vehicleManagerKey = "vehicleMgr";
    public static final String bulkReissueListManagerKey = "bulkReissueListMgr";
    public static final String bulkReissueMaintManagerKey = "bulkReissueMaintMgr";
    public static final String transDetailManagerKey = "transDetailMgr";
    public static final String transactionDetailItemManagerKey = "transactionDetailItemMgr";
    public static final String settLementsDetailManagerKey = "settLementsDetailMgr";
    public static final String marketingMessagesManagerKey = "marketingMessagesMgr";
    public static final String marketingMessagesListMgr = "marketingMessagesListMgr";
    public static final String inetHostClientMapManagerKey = "inetHostClientMapMgr";

    public BaseBean() {

        this(true);
    }

    /* This boolean value is added for test purpose */
    public BaseBean(boolean isToInitiate) {

        if (isToInitiate) {
            initializeBaseBean();
        }
    }

    /**
     *
     */
    public void initializeBaseBean() {


    }

    //protected abstract IFCSJaasPrincipalVO[] getRoles();

    /**
     * if on the xhtml page the tag <f:view> contain the attribute beforePhase
     * and the brean was set the system module the bean will validate all fields
     * inside of anny forms on this page
     *
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     **/
    public void beforePhase(final PhaseEvent event)
            throws IllegalArgumentException, IllegalAccessException{

        String test = Constants.HOME_HOMEPAGE_XHTML;

    }


}
