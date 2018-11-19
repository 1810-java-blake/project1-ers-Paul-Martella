const pg = require('pg');

const connectionName = process.env.INSTANCE_CONNECTION_NAME || 'project1-222909:us-central1:projct1db';
const dbUser = process.env.SQL_USER || 'postgres';
const dbPassword = process.env.SQL_PASSWORD || 'Nb2345rccddfd$sd';
const dbName = process.env.SQL_NAME || 'postgres';

const pgConfig = {
  max: 1,
  user: dbUser,
  password: dbPassword,
  database: dbName
};

if (process.env.NODE_ENV === 'production') {
  pgConfig.host = `/cloudsql/${connectionName}`;
}

// Connection pools reuse connections between invocations,
// and handle dropped or expired connections automatically.
let pgPool;

exports.deny = (req, res) => {
  
  res.set('Access-Control-Allow-Origin', "*");
  res.set('Access-Control-Allow-Methods', "GET");
  res.set('Access-Control-Allow-Headers', "Content-Type");
  res.set('Access-Control-Max-Age', "3600");
  
  // Initialize the pool lazily, in case SQL access isn't needed for this
  // GCF instance. Doing so minimizes the number of active SQL connections,
  // which helps keep your GCF instances under SQL connection limits.
  if (!pgPool) {
    pgPool = new pg.Pool(pgConfig);
  }

  pgPool.query("update ers_reimbursement set reimb_status_id=3 where ers_user_id=?;", (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {
      res.send(JSON.stringify(results));
      console.log(results);
    }
  });

  // Close any SQL resources that were declared inside this function.
  // Keep any declared in global scope (e.g. mysqlPool) for later reuse.

};