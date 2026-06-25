// https://leetcode.com/problems/employee-importance/description/
// using dfs
// t.c.=O(n), s.c.=O(n)
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private int totalImportance=0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeGraph=new HashMap<>();
        for(Employee emp:employees)
            employeeGraph.put(emp.id, emp);
        dfs(employeeGraph, employeeGraph.get(id));
        return totalImportance;
    }
    private void dfs(Map<Integer, Employee> employeeGraph, Employee emp) {
        totalImportance+=emp.importance;
        for(Integer subordinate:emp.subordinates)
            dfs(employeeGraph, employeeGraph.get(subordinate));
    }
}
