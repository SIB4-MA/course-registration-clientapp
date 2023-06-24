package com.registration.course.clientapp.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.course.clientapp.models.dto.request.TransactionStatusAndIsRegisteredRequest;
import com.registration.course.clientapp.services.TransactionService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/dasboard/transaction")
public class TransactionDasboardController {

  private TransactionService transactionService;

  @GetMapping
  public String getAllTransactions(Model model,
      TransactionStatusAndIsRegisteredRequest transactionStatusAndIsRegisteredRequest) {
    model.addAttribute("transactions", transactionService.getAll().getPayload());

    return "admin/transaction/transaction";
  }

}
