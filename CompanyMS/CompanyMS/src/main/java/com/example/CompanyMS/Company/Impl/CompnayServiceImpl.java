package com.example.CompanyMS.Company.Impl;

import com.example.CompanyMS.Company.Company;
import com.example.CompanyMS.Company.CompanyService;
import com.example.CompanyMS.Company.clients.ReviewClient;
import com.example.CompanyMS.Company.dto.ReviewMessage;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;
import com.example.CompanyMS.Company.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompnayServiceImpl  implements CompanyService {


    private CompanyRepository CompanyRepository;
    private ReviewClient reviewClient;


    public CompnayServiceImpl(com.example.CompanyMS.Company.CompanyRepository companyRepository, ReviewClient reviewClient) {
        CompanyRepository = companyRepository;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<Company> getAllCompanyies() {
        return CompanyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long Id) {
        Optional<Company> CompanyOptional = CompanyRepository.findById(Id);
        if(CompanyOptional.isPresent()){
            Company companyToUpdate = CompanyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());

            CompanyRepository.save(companyToUpdate);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        CompanyRepository.save(company);
    }

    @Override
    public boolean deleteCompnayById(Long id) {
        if(CompanyRepository.existsById(id)){
            CompanyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return CompanyRepository.findById(id).orElse(null);

    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        if (reviewMessage.getCompanyId() == null) {
            throw new IllegalArgumentException("Company ID cannot be null");
        }

        Company company = CompanyRepository.findById(reviewMessage.getCompanyId())
                .orElseThrow(() -> new NotFoundException("Company not found: " + reviewMessage.getCompanyId()));

        System.out.println(company.getDescription());
        System.out.println("Company ID in UpdateRating" + company.getId());
        double averageRating = reviewClient.getAverageRatingForCompany(company.getId());
        System.out.println(averageRating);
        company.setRating(averageRating);
        CompanyRepository.save(company);
    }



}
