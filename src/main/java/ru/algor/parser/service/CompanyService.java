package ru.algor.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.algor.parser.entity.Company;
import ru.algor.parser.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    //    public void addCompanyByLink(String link){
//        if (!companyRepository.existsByLink(link)) {
//            Company company = new Company();
//            company.setLink(link);
//            companyRepository.save();
//        }
//    }
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }


}
