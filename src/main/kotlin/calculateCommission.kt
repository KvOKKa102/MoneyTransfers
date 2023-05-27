fun calculateCommission(amount: Int, cardType: String, transferType: String): Double {
    var commission = 0.0

    when (cardType) {
        "Mastercard", "Maestro" -> {
            if (amount >= 300 && amount <= 75_000) {
                commission = 0.0
            } else {
                commission = amount * 0.0075
                if (commission < 35) {
                    commission = 35.0
                }
            }
        }

        "Visa", "Mir" -> {
            commission = amount * 0.0075
            if (commission < 35) {
                commission = 35.0
            }
        }

        "VK Pay" -> {
            commission = amount * 0.0075
            if (commission < 35) {
                commission = 35.0
            }
        }

        else -> {
            println("Неверный тип карты")
            return commission
        }
    }

    when (transferType) {
        "Sending" -> {
            if (amount > 150_000) {
                println("Максимальная сумма переводов по одной карте составляет 150_000 рублей в день")
                return commission
            }
        }

        "Receiving" -> {
            if (amount > 600_000) {
                println("Максимальная сумма переводов по одной карте составляет 600_000 рублей в месяц")
                return commission
            }
        }

        else -> {
            println("Неверный тип перевода")
            return commission
        }
    }

    if (cardType == "VK Pay" && amount > 15_000) {
        println("Максимальная сумма переводов со счета VK Pay - составляет 15_000 рублей за один раз")
        return commission
    } else if (cardType != "VK Pay" && amount > 40_000) {
        println("Максимальная сумма переводов со счета VK Pay - составляет 40_000 рублей в месяц")
        return commission
    }

    return commission
}