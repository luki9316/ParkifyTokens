package agh.parkify.tokens

class TokenManager(submissionBonus: Int, usageLoss: Int) {

  val tokenRepository: TokenRepository = new TokenRepository

  def addSubmissionBonus(userId: Long, amount: Int = submissionBonus): Unit =
    tokenRepository.addTokenForUser(Token(userId, amount))

  def addUsageLoss(userId: Long, amount: Int = usageLoss): Unit =
    tokenRepository.addTokenForUser(Token(userId, -amount))

  def getUserPointsSum(userId: Long): Int = tokenRepository.getUserTokens(userId).map(_.points).sum

  def getUserTokenHistory(userId: Long): Set[Token] = tokenRepository.getUserTokens(userId)

  def tryAddUsageLoss(userId: Long, amount: Int = usageLoss): Boolean = {
    if (getUserPointsSum(userId) > amount) {
      addUsageLoss(userId, amount)
      return true
    }
    return false
  }
}
