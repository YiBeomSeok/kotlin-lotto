package org.bmsk.domain.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringAdditionCalculatorTest : FunSpec({

    context("구분자를 기준으로 숫자를 분리해낸다.") {
        test("빈 문자열이면 빈 리스트를 반환한다.") {
            StringAdditionCalculator("").separateBy() shouldBe emptyList()
        }

        test("\"1, 2\"는 [1, 2]이다.") {
            StringAdditionCalculator("1, 2").separateBy() shouldBe listOf(1, 2)
        }

        test("\"1, 2, 3\"은 [1, 2, 3]이다.") {
            StringAdditionCalculator("1, 2, 3").separateBy() shouldBe listOf(1, 2, 3)
        }

        test("\"1\"은 [1]이다.") {
            StringAdditionCalculator("1").separateBy() shouldBe listOf(1)
        }

        test("\"1,2:3\"은 [1, 2, 3]이다.") {
            StringAdditionCalculator("1,2:3").separateBy() shouldBe listOf(1, 2, 3)
        }
    }
})