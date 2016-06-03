package hmda.validation.rules.lar.quality

import hmda.model.fi.lar.LoanApplicationRegister
import hmda.validation.rules.EditCheck
import hmda.validation.rules.lar.LarEditCheckSpec
import org.scalacheck.Gen

class Q059Spec extends LarEditCheckSpec {
  property("Lars with loan type equal to 1 must pass") {
    forAll(larGen) { lar =>
      val newLoan = lar.loan.copy(loanType = 1)
      val newLar = lar.copy(loan = newLoan)
      newLar.mustPass
    }
  }

  val relevantLoanType: Gen[Int] = Gen.choose(2, 4)

  property("Lar with relevant loan type and property type equal to 3 must fail") {
    forAll(larGen, relevantLoanType) { (lar, x) =>
      val newLoan = lar.loan.copy(loanType = x, propertyType = 3)
      val newLar = lar.copy(loan = newLoan)
      newLar.mustFail
    }
  }

  val irrelevantPropertyType: Gen[Int] = Gen.choose(Int.MinValue, Int.MaxValue).filter(_ != 1)

  property("Lar with relevant loan type and property type not equal to 3 must pass") {
    forAll(larGen, relevantLoanType, irrelevantPropertyType) { (lar, x, y) =>
      val newLoan = lar.loan.copy(loanType = x, propertyType = y)
      val newLar = lar.copy(loan = newLoan)
      newLar.mustPass
    }
  }

  override def check: EditCheck[LoanApplicationRegister] = Q059
}
