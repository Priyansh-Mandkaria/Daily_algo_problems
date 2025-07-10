// Last updated: 7/10/2025, 8:49:01 AM
import java.util.regex.Pattern;
import java.util.regex.Pattern;
class Solution {
    static class CouponInfo {
        String code;
        String businessLine;
        CouponInfo(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<CouponInfo> temp = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        Pattern p = Pattern.compile("^[A-Za-z0-9_]+$");
        for(int i = 0 ; i < code.length; i++){
            if(code[i] != null && !code[i].isEmpty() && p.matcher(code[i]).matches()){
                if(businessLine[i].equals("electronics") || businessLine[i].equals("grocery") || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")){
                    if(isActive[i] == true) temp.add(new CouponInfo(code[i], businessLine[i]));;
                }
            }
        }
        var businessLineOrder = new java.util.HashMap<String, Integer>();
        businessLineOrder.put("electronics", 0);
        businessLineOrder.put("grocery", 1);
        businessLineOrder.put("pharmacy", 2);
        businessLineOrder.put("restaurant", 3);
        temp.sort((a, b) -> {
            int cmp = Integer.compare(businessLineOrder.get(a.businessLine), businessLineOrder.get(b.businessLine));
            return cmp != 0 ? cmp : a.code.compareTo(b.code);
        });
        var arr2 = new java.util.ArrayList<String>();
        for (var coupon : temp) arr2.add(coupon.code);
        return arr2;
    }
}