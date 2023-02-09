import java.util.ArrayList;

public class binary {
    ArrayList<String> words = new ArrayList<>();
    public int inList(ArrayList<String> list, int low, int high, String target){

        // base case
        if(low <= high){
            int mid = (low+high)/2;
            if (list.get(mid).equals(target))
                    return mid;
            else if (list.get(mid).compareTo(target) < 0)
                return inList(list, mid+1, high, target);

            else
                return inList(list, low, mid-1, target);
        }
        return -1;

    }
    boolean binarySearchGil(ArrayList<String> arr, String x)
    {
        boolean smurfs = false;
        int right = arr.size()-1;
        int left = 0;

        while(left <= right) {
            int mid = left + (right - left)/2;
            System.out.println(arr.get(mid));
            for(int i = 0; i < x.length() && i < arr.get(mid).length(); i++) {
                if(x.length() >= arr.get(mid).length()) {
                    if (x.charAt(i) == arr.get(mid).charAt(i)) {
                        smurfs = true;
                    } else {
                        if (x.charAt(i) > arr.get(mid).charAt(i)) {
                            smurfs = true;
                            break;
                        } else {
                            smurfs = false;
                            break;
                        }
                    }
                }
                else{
                    smurfs = false;
                    break;
                }
            }

            // Check if x is present at mid
            if (arr.get(mid).equals(x))
                return true;

                // If x greater, ignore left half
            else if (smurfs)
                left = mid + 1;

                // If x is smaller, ignore right half
            else
                right = mid - 1;
        }

        // if we reach here, then element was
        // not present
        return false;
    }
}
