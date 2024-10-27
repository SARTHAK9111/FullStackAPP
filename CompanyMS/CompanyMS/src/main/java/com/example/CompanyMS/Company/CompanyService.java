package com.example.CompanyMS.Company;


import java.util.List;

public interface CompanyService {

     public List<Company> getAllCompanyies();

     boolean updateCompany(Company company, Long Id);

     void createCompany(Company company);

     boolean deleteCompnayById(Long id);

     Company getCompanyById(Long id);
}
