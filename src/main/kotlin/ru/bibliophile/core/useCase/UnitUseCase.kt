package ru.bibliophile.core.useCase

abstract class UnitUseCase<Output> {
    suspend fun execute(): Output {
        return run()
    }

    protected abstract suspend fun run(): Output
}