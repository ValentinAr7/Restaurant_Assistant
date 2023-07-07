import { Route, Routes } from "react-router-dom";
import { useState } from "react";
import "./App.css";
import Sidebar from "./components/sidebar/SideBar";
import Dashboard from "./screens/admin/Dashboard/Dashboard";
import TablesSection from "./screens/admin/sections/TableSections";
import Restaurant from "./screens/admin/restaurants/Restaurant";
import Transactions from "./screens/admin/Transactions/Transactions";
import Users from "./screens/admin/employees/Employees";
import Customer from "./screens/customer/Customer";
import LoginScreen from "./screens/login/LoginScreen";
import loginData from "./screens/login/loginData";
import { TablesList } from "./screens/admin/tables/TablesList";

function App() {
  const [loggedIn, setLoggedIn] = useState(false);
  const [userType, setUserType] = useState("");

  const handleLoggedIn = (loggedIn: boolean) => {
    setLoggedIn(loggedIn);
  };

  const handleUserType = (userType: string) => {
    setUserType(userType);
  };

  if (loggedIn) {
    if (userType === loginData.user.role) {
      return (
        <div>
          <Customer appUserId={1} appTableId={1} />
        </div>
      );
    } else {
      return (
        <div>
          <Sidebar />
          <Routes>
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/users" element={<Users />} />
            <Route path="/restaurant" element={<Restaurant />} />
            <Route path="/tables" element={<TablesList />} />
            <Route path="/sections" element={<TablesSection />} />
            <Route path="/transactions" element={<Transactions />} />
          </Routes>
        </div>
      );
    }
  } else {
    return (
      <LoginScreen setLoggedIn={handleLoggedIn} setUserType={handleUserType} />
    );
  }
}

export default App;
