package hmda.query.model.filing

case class ModifiedLoanApplicationRegister(
  id: String,
  respondentId: String,
  agencyCode: Int,
  preapprovals: Int,
  actionTakenType: Int,
  //actionTakenDate: Int,
  purchaserType: Int,
  rateSpread: String,
  hoepaStatus: Int,
  lienStatus: Int,
  //loanId: String,
  //applicationDate: String,
  loanType: Int,
  propertyType: Int,
  purpose: Int,
  occupancy: Int,
  amount: Int,
  msa: String,
  state: String,
  county: String,
  tract: String,
  ethnicity: Int,
  coEthnicity: Int,
  race1: Int,
  race2: String,
  race3: String,
  race4: String,
  race5: String,
  coRace1: Int,
  coRace2: String,
  coRace3: String,
  coRace4: String,
  coRace5: String,
  sex: Int,
  coSex: Int,
  income: String,
  denialReason1: String,
  denialReason2: String,
  denialReason3: String,
  period: String
)
