export function success(res, data, message = 'OK', status = 200) {
  return res.status(status).json({
    success: true,
    message,
    data,
    timestamp: new Date().toISOString()
  });
}

export function created(res, data = null, message = 'Created') {
    return res.status(201).json({
    success: true,
    message,
    data,
    timestamp: new Date().toISOString()
    });
}

export function error(res, message = 'Error', status = 500, details = null) {
    return res.status(status).json({
    success: false,
    message,
    ...(details && { details }),
    timestamp: new Date().toISOString()
    });
}