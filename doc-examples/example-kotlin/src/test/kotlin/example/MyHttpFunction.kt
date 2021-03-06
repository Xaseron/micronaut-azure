package example

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*
import io.micronaut.azure.function.http.AzureHttpFunction
import java.util.*

class MyHttpFunction : AzureHttpFunction() { // <1>
    @FunctionName("ExampleTrigger") // <2>
    fun invoke(
            @HttpTrigger(name = "req",
                    methods = [HttpMethod.GET, HttpMethod.POST], // <3>
                    route = "{*route}", // <4>
                    authLevel = AuthorizationLevel.ANONYMOUS) // <5>
            request: HttpRequestMessage<Optional<String>>,  // <6>
            context: ExecutionContext): HttpResponseMessage {
        return super.route(request, context) // <7>
    }
}