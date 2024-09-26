function fn() {
  var env = karate.env; // get system property 'karate.env'
  var os = karate.os;
  karate.log('karate.env system property was:', env);
  karate.log("Your OS Is",os);

  if (!env) {
    env = 'roc-stg';

  }
  var config = {
    env: env,
    baseUrl: 'https://bookstore.toolsqa.com',
     os : os,
  }
  if (env == 'dev') {
      config.baseUrl = 'https://bookstore.toolsqa.com';
      config.baseUrlWeb="https://www.google.com/";
  } else if (env == 'roc-sit') {
      config.baseUrl="https://bookstore.toolsqa.com";
      config.baseUrlWeb="https://www.google.com/";
   } else if (env == 'roc-stg') {
      config.baseUrl="https://bookstore.toolsqa.com";
      config.baseUrlWeb="https://www.google.com/";
   }
   karate.configure('logPrettyResponse', true);
   karate.configure('logPrettyRequest', true);
   var db = karate.callSingle('classpath:auto/features/common/common-feature/DatabaseCommon.feature', config);
   config.db = db;
  return config;
}