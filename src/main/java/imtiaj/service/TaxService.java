package imtiaj.service;


import imtiaj.model.Tax;
import imtiaj.repository.TaxRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaxService {

    private TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public void create(Tax tax) {
        tax.setTotalIncome(tax.getTotalIncome() * 12);
        if (tax.getTotalIncome() > 0 && tax.getTotalIncome() <= 300000) {
            tax.setTaxAmount(0);
            taxRepository.create(tax);
        } else if (tax.getTotalIncome() > 300000 && tax.getTotalIncome() <= 400000) {
            tax.setTaxAmount(((double) 5 / 100) * tax.getTotalIncome());
            taxRepository.create(tax);
        } else if (tax.getTotalIncome() > 400000 && tax.getTotalIncome() <= 500000) {
            tax.setTaxAmount(((double) 10 / 100) * tax.getTotalIncome());
            taxRepository.create(tax);
        } else if (tax.getTotalIncome() > 500000 && tax.getTotalIncome() <= 600000) {
            tax.setTaxAmount(((double) 15 / 100) * tax.getTotalIncome());
            taxRepository.create(tax);
        } else if (tax.getTotalIncome() > 600000 && tax.getTotalIncome() <= 3000000) {
            tax.setTaxAmount(((double) 20 / 100) * tax.getTotalIncome());
            taxRepository.create(tax);
        } else if (tax.getTotalIncome() > 3000000) {
            tax.setTaxAmount(((double) 25 / 100) * tax.getTotalIncome());
            taxRepository.create(tax);
        }

    }

    public List<Tax> getAll() {
        return taxRepository.getAll();
    }

    public Tax get(int id) {
        return taxRepository.get(id);
    }

    public void delete(int id) {
        taxRepository.delete(id);
    }

    public void edit(Tax tax) {
        taxRepository.edit(tax);
    }

}
