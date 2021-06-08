/*
 * Copyright 2020-2021 Google LLC
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.mp.PhysicalTrainerV1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  /**
   * Spring Security allows users to easily inject the default security headers to assist in
   * protecting their application. The default for Spring Security is to include the following
   * headers: Cache-Control: no-cache, no-store, max-age=0, must-revalidate Pragma: no-cache
   * Expires: 0 X-Content-Type-Options: nosniff Strict-Transport-Security: max-age=31536000 ;
   * includeSubDomains X-Frame-Options: DENY X-XSS-Protection: 1; mode=block
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
   
      http.csrf().disable();
  }

 
}
