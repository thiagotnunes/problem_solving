package sorting.exercises.exercise_8;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a list of patients with low, mid and high priority,
 * sort them in priority order
 */
public class Solution {
    private static class Patient {
        public final String name;
        public final int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Patient{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }

    /**
     * Insertion sort
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public void solve1(Patient[] patients) {
        int n = patients.length;

        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j > 0 && patients[j].priority < patients[j - 1].priority) {
                Patient tmp = patients[j];
                patients[j] = patients[j - 1];
                patients[j - 1] = tmp;
                j--;
            }
        }
    }

    /**
     * Merge sort
     * Time complexity - O(nlogn)
     * Space complexity - O(n)
     */
    public void solve2(Patient[] patients) {
        mergeSort(patients, 0, patients.length - 1, new Patient[patients.length]);
    }

    private void mergeSort(Patient[] patients, int lo, int hi, Patient[] buffer) {
        if (lo >= hi) {
            return;
        }

        int mid = (hi - lo) / 2 + lo;
        mergeSort(patients, lo, mid, buffer);
        mergeSort(patients, mid + 1, hi, buffer);

        merge(patients, lo, hi, buffer);
    }

    private void merge(Patient[] patients, int lo, int hi, Patient[] buffer) {
        int mid = (hi - lo) / 2 + lo;

        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                buffer[k] = patients[j++];
            } else if (j > hi) {
                buffer[k] = patients[i++];
            } else if (patients[i].priority <= patients[j].priority) {
                buffer[k] = patients[i++];
            } else {
                buffer[k] = patients[j++];
            }
            k++;
        }

        System.arraycopy(buffer, lo, patients, lo, hi - lo + 1);
    }

    /**
     * Bucket sort
     * Time complexity - O(n + k)
     * Space complexity - O(n + k)
     */
    public void solve3(Patient[] patients) {
        // 0 -> low
        // 1 -> mid
        // 2 -> high
        ArrayList<ArrayList<Patient>> patientsByPriority = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            patientsByPriority.add(new ArrayList<>());
        }

        for (Patient patient : patients) {
            patientsByPriority.get(patient.priority).add(patient);
        }

        int k = 0;
        for (ArrayList<Patient> priorityPatients : patientsByPriority) {
            for (Patient priorityPatient : priorityPatients) {
                patients[k++] = priorityPatient;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Patient[] patients = {
                new Patient("a", 0),
                new Patient("b", 2),
                new Patient("c", 1),
                new Patient("d", 1),
                new Patient("e", 0),
                new Patient("f", 2)
        };

        solution.solve2(patients);

        System.out.println(Arrays.toString(patients));
    }
}
