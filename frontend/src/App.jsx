import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [employees, setEmployees] = useState([])
  const [highSalaryEmployees, setHighSalaryEmployees] = useState([])
  const [loading, setLoading] = useState(false)

  const fetchEmployees = async () => {
    setLoading(true)
    try {
      const response = await fetch('http://localhost:8080/employees')
      const data = await response.json()
      setEmployees(data)
    } catch (error) {
      console.error('Error fetching employees:', error)
    }
    setLoading(false)
  }

  const fetchHighSalaryEmployees = async () => {
    setLoading(true)
    try {
      const response = await fetch('http://localhost:8080/employees/high-salary')
      const data = await response.json()
      setHighSalaryEmployees(data)
    } catch (error) {
      console.error('Error fetching high salary employees:', error)
    }
    setLoading(false)
  }

  return (
    <div className="App">
      <h1>Employee Management</h1>
      
      <div className="buttons">
        <button onClick={fetchEmployees}>Get All Employees</button>
        <button onClick={fetchHighSalaryEmployees}>Get High Salary Employees</button>
      </div>

      {loading && <p>Loading...</p>}

      {employees.length > 0 && (
        <div className="employee-section">
          <h2>All Employees</h2>
          <ul>
            {employees.map((emp, index) => (
              <li key={index}>
                {emp.name} - ₹{emp.salary.toLocaleString()}
              </li>
            ))}
          </ul>
        </div>
      )}

      {highSalaryEmployees.length > 0 && (
        <div className="employee-section">
          <h2>High Salary Employees (>₹60,000)</h2>
          <ul>
            {highSalaryEmployees.map((emp, index) => (
              <li key={index}>
                {emp.name} - ₹{emp.salary.toLocaleString()}
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  )
}

export default App