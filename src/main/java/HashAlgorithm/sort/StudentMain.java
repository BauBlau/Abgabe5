package HashAlgorithm.sort;

public class StudentMain {
    public static void main(String[] args) {
        Student s1 = new Student("Adam","Apfel", 10,1);
        Student s2 = new Student("Bernt", "Brot", 10, 2);
        Student s3 = new Student ("Chester", "Chrysler", 10, 3);
        Student s4 = new Student ("Denis","Dose", 10, 4);
        Student s5 = new Student ("Emil", "Eis", 10, 5);

        int arr[]={s3.getMatriculationNumber(),s2.getMatriculationNumber(),s1.getMatriculationNumber(),s4.getMatriculationNumber(),s5.getMatriculationNumber()};
        StudentMain ob = new StudentMain();
        int l = arr.length;

        //ob.insertionSort(arr);
        //ob.heapSort(arr);
        //ob.bubbleSort(arr);
        //ob.sort(arr,0,l-1);
        //printArray(arr);



        for(int i=0;i<l;i++){
            if(arr[i]==s1.getMatriculationNumber()){
                System.out.println(s1);
            }else if(arr[i]==s2.getMatriculationNumber()){
                System.out.println(s2);
            }else if(arr[i]==s3.getMatriculationNumber()){
                System.out.println(s3);
            }else if(arr[i]==s4.getMatriculationNumber()){
                System.out.println(s4);
            }else if(arr[i]==s5.getMatriculationNumber()) {
                System.out.println(s5);
            }
        }




    }

    public static void insertionSort(int arr[]){
            int n = arr.length;
            for (int i=1;i<n;i++){
                int key = arr[i];
                int j = i-1;

                while(j>=0 &&arr[j]>key){
                    arr[j+1] = arr[j];
                    j=j-1;
                }
                arr[j+1] = key;
            }
    }

    public static void heapSort(int arr[]){
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);


        for (int i=n-1; i>0; i--)
        {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }


    static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;


        if (l < n && arr[l] > arr[largest])
            largest = l;


        if (r < n && arr[r] > arr[largest])
            largest = r;


        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, n, largest);
        }

    }

        public static void bubbleSort(int arr[]){
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j] > arr[j+1])
                    {

                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }



        public static int quickSort(int arr[], int low, int high) {

            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {

                if (arr[j] < pivot) {
                    i++;


                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }


       public static  void sort ( int arr[], int low, int high){

                if (low < high) {

                    int pi = quickSort(arr, low, high);

                    sort(arr, low, pi - 1);
                    sort(arr, pi + 1, high);

                }
            }




    static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();

    }


}
