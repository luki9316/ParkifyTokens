package agh.parkify.tokens

class TokenRepository {

    private var allTokens: Set[Token] = Set()

    def getAllTokens(): Set[Token] = allTokens

    def addTokenForUser(token: Token): Unit = allTokens = allTokens + token

    def getUserTokens(userId: Long): Set[Token] = allTokens.filter(token => token.userId == userId)
}
