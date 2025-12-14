// Last updated: 12/14/2025, 10:59:05 AM
1import java.util.regex.Pattern;
2import java.util.regex.Pattern;
3class Solution {
4    static class CouponInfo {
5        String code;
6        String businessLine;
7        CouponInfo(String code, String businessLine) {
8            this.code = code;
9            this.businessLine = businessLine;
10        }
11    }
12    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
13        List<CouponInfo> temp = new ArrayList<>();
14        List<String> arr = new ArrayList<>();
15        Pattern p = Pattern.compile("^[A-Za-z0-9_]+$");
16        for(int i = 0 ; i < code.length; i++){
17            if(code[i] != null && !code[i].isEmpty() && p.matcher(code[i]).matches()){
18                if(businessLine[i].equals("electronics") || businessLine[i].equals("grocery") || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")){
19                    if(isActive[i] == true) temp.add(new CouponInfo(code[i], businessLine[i]));;
20                }
21            }
22        }
23        var businessLineOrder = new java.util.HashMap<String, Integer>();
24        businessLineOrder.put("electronics", 0);
25        businessLineOrder.put("grocery", 1);
26        businessLineOrder.put("pharmacy", 2);
27        businessLineOrder.put("restaurant", 3);
28        temp.sort((a, b) -> {
29            int cmp = Integer.compare(businessLineOrder.get(a.businessLine), businessLineOrder.get(b.businessLine));
30            return cmp != 0 ? cmp : a.code.compareTo(b.code);
31        });
32        var arr2 = new java.util.ArrayList<String>();
33        for (var coupon : temp) arr2.add(coupon.code);
34        return arr2;
35    }
36}