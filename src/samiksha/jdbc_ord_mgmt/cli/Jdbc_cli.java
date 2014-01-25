package samiksha.jdbc_ord_mgmt.cli;

import samiksha.jdbc_ord_mgmt.lib.OrdMgmt;

/**
 * Created by samiksha on 1/24/14.
 */
public class Jdbc_cli {
    public static void main(String[] args)throws Exception{
        OrdMgmt om = new OrdMgmt();
        System.out.println(om.connect());
    }
}
