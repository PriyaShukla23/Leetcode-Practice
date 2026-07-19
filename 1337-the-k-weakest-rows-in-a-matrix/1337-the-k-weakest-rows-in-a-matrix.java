class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {

        int rows = mat.length;
        int[][] arr = new int[rows][2];

        // Count soldiers
        for (int i = 0; i < rows; i++) {

            int count = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    count++;
            }

            arr[i][0] = count;
            arr[i][1] = i;
        }

        mergeSort(arr, 0, rows - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = arr[i][1];
        }

        return ans;
    }

    void mergeSort(int[][] arr, int low, int high) {

        if (low >= high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    void merge(int[][] arr, int low, int mid, int high) {

        int[][] temp = new int[high - low + 1][2];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i][0] < arr[j][0] ||
               (arr[i][0] == arr[j][0] && arr[i][1] < arr[j][1])) {

                temp[k][0] = arr[i][0];
                temp[k][1] = arr[i][1];
                i++;
            } else {

                temp[k][0] = arr[j][0];
                temp[k][1] = arr[j][1];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k][0] = arr[i][0];
            temp[k][1] = arr[i][1];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k][0] = arr[j][0];
            temp[k][1] = arr[j][1];
            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {
            arr[low + x][0] = temp[x][0];
            arr[low + x][1] = temp[x][1];
        }
    }
}