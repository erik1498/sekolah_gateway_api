package com.erickhene.gateway.keycloak;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j
public class KeycloakAuth {
    public Boolean authToken(String token){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "token=eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJSZGthNldQbVc5dDdoTDFxUjN0WTZhVjhTeFJWajVpcWZpOFc2MkZwUHNFIn0.eyJleHAiOjE2NzYxMDY4MzcsImlhdCI6MTY3NjEwNjUzNywianRpIjoiNjZkY2E1MmEtNmYzZS00ODAwLTlmZGQtMjk0MDQwMjlmZTBhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDoyMDAwL2F1dGgvcmVhbG1zL3Nla29sYWgiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiYmJlZjljNDItMzFiNy00MWNkLWEyOTYtODEwZjhmNDc3OGM5IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoic2Vrb2xhaF9jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiMjUxNzQyODAtMjBhOC00NTAzLTg4MzQtZWY4Zjc3YTQ3YTU0IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLXNla29sYWhfcmVhbG0iLCJvZmZsaW5lX2FjY2VzcyIsImt1cmlrdWx1bSIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiMjUxNzQyODAtMjBhOC00NTAzLTg4MzQtZWY4Zjc3YTQ3YTU0IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoiU2Vrb2xhaCBLdXJpa3VsdW0iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJrdXJpa3VsdW0iLCJnaXZlbl9uYW1lIjoiU2Vrb2xhaCIsImZhbWlseV9uYW1lIjoiS3VyaWt1bHVtIn0.xUhvHGAfWrJaCmHeYcBBW6Mm-qmmxvcH19JF92L0k8D-JCr5IjPccyV5bssaNy3N2qkK4kWRnowv_baG53mOw4IMIlKRxJA6fW4oV4dr6XVINqiIxwZhNsJ1IomEK3cgRypLEDjvUUD9IX21JCXLKBCiawDa8VvxI7doNb8kEwoyqwbrbDF2xO6g_NCpolvrwMOXKJKpz07piM9_1QD5CBzRoWnN9wR_zLZVRKG2sBYt2S3q_iHKm0F7FEp5wZjylD7io1xKnWNpP0lqO5ReAi5lc72q93Y4-ipJsnCsnkJQTSUX2UtRgQo0sS7CDuzVMNH-fVSDIA-CgEMxyS1rjA&client_id=sekolah_client&client_secret=rbYfLI04n8IzGg88YaCT0eH9hXrMswqV");
            Request request = new Request.Builder()
                    .url("http://localhost:2000/auth/realms/sekolah/protocol/openid-connect/token/introspect")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response response = client.newCall(request).execute();
            return true;
        } catch (IOException e) {
            log.error("Error [{}]", e.getMessage());
            return false;
        }
    }
}
